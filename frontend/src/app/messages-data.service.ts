import { Injectable } from '@angular/core';
import { Message } from './message.model';
import { ApiService } from './api.service';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MessagesDataService {
  messages: Message[] = [];
  private messagesSubject = new BehaviorSubject<Message[]>([]);
  messages$ = this.messagesSubject.asObservable();

  constructor(private apiService: ApiService) {}

  getMessages() {
    return this.messagesSubject.value;
  }

  getChatId() {
    return this.messagesSubject.value.length > 0
      ? this.messagesSubject.value[0].chatId
      : null;
  }

  setDefaultChatId(id: string) {
    const messages = this.messagesSubject.value;
    messages[0].chatId = id;
    this.messagesSubject.next(messages);
  }

  newChat(id: string | null) {
    if (id == null) {
      this.clearMessages();
    } else {
      this.apiService.getMessagesByChat(id).subscribe((response: Message[]) => {
        this.messagesSubject.next(response);
      });
    }
    console.log(id);
    console.log(this.messagesSubject.value);
  }

  addMessage(message: Message) {
    const messages = this.messagesSubject.value;
    messages.push(message);
    this.messagesSubject.next(messages);
  }

  clearMessages() {
    this.messagesSubject.next([]);
  }

  sendMessage(question: string) {
    const newMessage: Message = {
      message: question,
      timeStamp: new Date(),
      isUser: true,
      chatId: this.getChatId(),
      userId: 'f271bb9b-d676-42f0-b6b2-7a6505f45a0e',
    };
    this.addMessage(newMessage);

    this.apiService
      .sendQuestion(newMessage)
      .subscribe(async (response: Message) => {
        //this.htmlContent = await this.markdownService.parse(response.message);

        // Preciso mudar o model do backend
        if (this.getChatId() == null) {
          this.setDefaultChatId(response.chatId!);
        }
        this.addMessage(response);
      });
  }
}
