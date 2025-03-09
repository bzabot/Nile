import { Component, OnInit, Input } from '@angular/core';
import { ChatSidebarComponent } from './chat-sidebar/chat-sidebar.component';
import { ChatContentComponent } from './chat-content/chat-content.component';
import { ApiService } from '../services/api.service';
import { Chat } from '../models/chat.model';
import { Message } from '../models/message.model';
import { MessageRecordDto } from '../services/api.service';
import { MessagesDataService } from '../services/messages-data.service';

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
