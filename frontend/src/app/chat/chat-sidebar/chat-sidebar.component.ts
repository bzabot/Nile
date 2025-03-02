import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IonIcon } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { searchOutline } from 'ionicons/icons';
import { Chat } from '../chat.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-chat-sidebar',
  standalone: true,
  imports: [IonIcon, CommonModule],
  templateUrl: './chat-sidebar.component.html',
  styleUrl: './chat-sidebar.component.css',
})
export class ChatSidebarComponent {
  constructor() {
    addIcons({ searchOutline });
  }

  @Input() chats: Chat[] = [];
  @Output() newItemEvent = new EventEmitter<string>();

  selectedChat: string = '';

  onSelect(event: Event, id: string) {
    event.preventDefault();
    this.selectedChat = id;
    this.newItemEvent.emit(this.selectedChat);
  }
}
