export class Review {
  value: string;
  comment: string;
  paperTitle: string;

  constructor(value: string, paperTitle: string, comment: string) {
    this.value = value;
    this.paperTitle = paperTitle;
    this.comment = comment;
  }
}
