import { Component, OnInit } from '@angular/core';
import { ChatSidebarComponent } from './chat-sidebar/chat-sidebar.component';
import { ChatContentComponent } from './chat-content/chat-content.component';
import { ApiService } from '../api.service';
import { Chat } from './chat.model';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [ChatSidebarComponent, ChatContentComponent],
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css',
})
export class ChatComponent implements OnInit {
  constructor(private apiService: ApiService) {}

  user: string = 'f271bb9b-d676-42f0-b6b2-7a6505f45a0e';
  chats: Chat[] = [];

  ngOnInit(): void {
    this.apiService.getChatsByUser(this.user).subscribe(
      (response: Chat[]) => {
        this.chats = response;
        console.log(response);
      },
      (error) => {
        console.error('Error fetching chats:', error);
        // Handle the error here
      }
    );
  }
}
