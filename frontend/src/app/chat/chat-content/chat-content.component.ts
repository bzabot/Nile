import { Component } from '@angular/core';
import { IonIcon } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { sendOutline } from 'ionicons/icons';
import { FormsModule } from '@angular/forms';
import { ApiService, MessageRecordDto } from '../../api.service';
import { CommonModule } from '@angular/common';
import { MarkdownService } from '../../markdown.service';

@Component({
  selector: 'app-chat-content',
  standalone: true,
  imports: [IonIcon, FormsModule, CommonModule],
  templateUrl: './chat-content.component.html',
  styleUrl: './chat-content.component.css',
})
export class ChatContentComponent {
  messages: MessageRecordDto[] = new Array();

  constructor(
    private apiService: ApiService,
    private markdownService: MarkdownService
  ) {
    addIcons({ sendOutline });
  }

  message: string = '';
  htmlContent: string = '';

  onSubmit() {
    const messageDto: MessageRecordDto = {
      message: this.message,
      timeStamp: new Date(),
      isUser: true,
      chatId: '028d91a5-2e71-48ac-ba2f-f09ec7ac176c',
      userId: 'f271bb9b-d676-42f0-b6b2-7a6505f45a0e',
    };
    this.messages.push(messageDto);

    this.apiService
      .sendQuestion(messageDto)
      .subscribe(async (response: MessageRecordDto) => {
        this.htmlContent = await this.markdownService.parse(response.message);
        this.messages.push(response);
      });
  }
}
