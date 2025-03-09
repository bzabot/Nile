export interface Message {
  message: string;
  timeStamp: Date;
  isUser: boolean;
  chatId: string | null;
  userId: string;
}
