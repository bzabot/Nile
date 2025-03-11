import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IonIcon } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { searchOutline } from 'ionicons/icons';
import { createOutline } from 'ionicons/icons';
import { Chat } from '../../models/chat.model';
import { CommonModule } from '@angular/common';
import { MessagesDataService } from '../../services/messages-data.service';
import { ChatDataService } from '../../services/chat-data.service';

@Component({
  selector: 'app-chat-sidebar',
  standalone: true,
  imports: [IonIcon, CommonModule],
  templateUrl: './chat-sidebar.component.html',
  styleUrl: './chat-sidebar.component.css',
})
export class ChatSidebarComponent implements OnInit {
  chats: Chat[] = [];

  constructor(
    private messagesData: MessagesDataService,
    private chatDataService: ChatDataService
  ) {
    addIcons({ searchOutline, createOutline });
  }

  ngOnInit(): void {
    this.chatDataService.refreshChats();
    this.chatDataService.chats$.subscribe((chats) => {
      this.chats = chats;
    });
  }

  onSelect(event: Event, id: string) {
    event.preventDefault();
    this.messagesData.newChat(id);
  }

  newChat(event: Event) {
    event.preventDefault();
    this.messagesData.newChat(null);
  }

  isActiveChat(chatId: string): boolean {
    return this.messagesData.getChatId() === chatId;
  }
}
