import { Component, OnInit, Input } from '@angular/core';
import { ChatSidebarComponent } from './chat-sidebar/chat-sidebar.component';
import { ChatContentComponent } from './chat-content/chat-content.component';
import { ApiService } from '../api.service';
import { Chat } from '../chat.model';
import { Message } from './message.model';
import { MessageRecordDto } from '../api.service';
import { MessagesDataService } from '../messages-data.service';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [ChatSidebarComponent, ChatContentComponent],
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css',
})
export class ChatComponent {
  constructor() {}
}
