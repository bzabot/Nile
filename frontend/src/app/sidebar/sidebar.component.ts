import { Component } from '@angular/core';
import { IonIcon } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { chatbubbleOutline } from 'ionicons/icons';
import { addCircleOutline } from 'ionicons/icons';
import { documentTextOutline } from 'ionicons/icons';
import { cardOutline } from 'ionicons/icons';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [IonIcon],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css',
})
export class SidebarComponent {
  constructor() {
    addIcons({
      chatbubbleOutline,
      addCircleOutline,
      documentTextOutline,
      cardOutline,
    });
  }
}
