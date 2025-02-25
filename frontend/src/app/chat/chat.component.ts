import { Component } from '@angular/core';
import { ChatSidebarComponent } from './chat-sidebar/chat-sidebar.component';
import { ChatContentComponent } from './chat-content/chat-content.component';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [ChatSidebarComponent, ChatContentComponent],
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css',
})
export class ChatComponent {}
