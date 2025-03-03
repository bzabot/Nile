import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SharedService {
  private actionTriggered = new Subject<void>();
  actionTriggered$ = this.actionTriggered.asObservable();

  triggerAction() {
    this.actionTriggered.next();
  }
}
