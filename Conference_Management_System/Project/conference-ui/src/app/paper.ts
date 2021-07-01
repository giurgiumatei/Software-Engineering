export class Paper {
  title: string;
  content: string;
  authorId: number;


  constructor(title: string, content: string, authorId: number) {
    this.title = title;
    this.content = content;
    this.authorId = authorId;
  }
}
