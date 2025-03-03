import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Chat } from './chat.model';
import { Message } from './chat/message.model';

export interface MessageRecordDto {
  message: string;
  timeStamp: Date;
  isUser: boolean;
  chatId: string | null;
  userId: string;
}

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) {}

  sendQuestion(message: MessageRecordDto): Observable<MessageRecordDto> {
    return this.http.post<MessageRecordDto>(this.apiUrl + 'question', message);
  }

  getChatsByUser(user: String) {
    return this.http.get<Chat[]>(this.apiUrl + 'chats/user/' + user);
  }

  getMessagesByChat(chat: string | null) {
    return this.http.get<Message[]>(this.apiUrl + 'chats/c/' + chat);
  }
}
