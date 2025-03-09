import {
  Component,
  Input,
  OnDestroy,
  OnInit,
  Output,
  EventEmitter,
} from '@angular/core';
import { IonIcon } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { sendOutline } from 'ionicons/icons';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Message } from '../../models/message.model';
import { MessagesDataService } from '../../services/messages-data.service';
import { ChatDataService } from '../../services/chat-data.service';

@Component({
  selector: 'app-chat-content',
  standalone: true,
  imports: [IonIcon, FormsModule, CommonModule],
  templateUrl: './chat-content.component.html',
  styleUrl: './chat-content.component.css',
})
export class ChatContentComponent implements OnInit {
  messages: Message[] = [];
  message: string = '';
  htmlContent: string = '';

  constructor(
    private messagesData: MessagesDataService,
    private chatDataService: ChatDataService
  ) {
    addIcons({ sendOutline });
  }

  ngOnInit() {
    this.messagesData.messages$.subscribe((messages) => {
      this.messages = messages;
    });
  }

  onSubmit(event: Event) {
    event.preventDefault();
    this.messagesData.sendMessage(this.message);
    this.message = '';
    this.chatDataService.refreshChats();
  }
}
