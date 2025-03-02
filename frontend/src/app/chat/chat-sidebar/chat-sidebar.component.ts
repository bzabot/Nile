import { Component, Input } from '@angular/core';
import { IonIcon } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { searchOutline } from 'ionicons/icons';
import { Chat } from '../chat.model';

@Component({
  selector: 'app-chat-sidebar',
  standalone: true,
  imports: [IonIcon],
  templateUrl: './chat-sidebar.component.html',
  styleUrl: './chat-sidebar.component.css',
})
export class ChatSidebarComponent {
  constructor() {
    addIcons({ searchOutline });
  }

  @Input() chats: Chat[] = [];
}
