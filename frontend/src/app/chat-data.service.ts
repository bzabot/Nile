import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Chat } from './chat.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ChatDataService {
  private chatsSubject = new BehaviorSubject<Chat[]>([]);
  chats$ = this.chatsSubject.asObservable();

  user: string = 'f271bb9b-d676-42f0-b6b2-7a6505f45a0e';

  constructor(private apiService: ApiService) {}

  refreshChats() {
    this.apiService.getChatsByUser(this.user).subscribe(
      (response: Chat[]) => {
        this.chatsSubject.next(response);
      },
      (error) => {
        console.error('Error fetching chats:', error);
      }
    );
  }

  getChats() {
    this.refreshChats();
    return this.chats$;
  }
}
