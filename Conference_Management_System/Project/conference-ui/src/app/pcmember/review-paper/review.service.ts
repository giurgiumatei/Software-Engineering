import {Injectable} from '@angular/core';
import {Review} from './review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  allReviews: Review[] = [];
  ALL_REVIEWS_SESSION_KEY = 'allReviews';

  constructor() {
  }

  addReview(review: Review): void {
    if (localStorage.getItem(this.ALL_REVIEWS_SESSION_KEY) === null){
      this.allReviews.push(review);
      sessionStorage.setItem(this.ALL_REVIEWS_SESSION_KEY, JSON.stringify(this.allReviews));
    }else {
      this.allReviews = JSON.parse(sessionStorage.getItem(this.ALL_REVIEWS_SESSION_KEY));
      this.allReviews.push(review);
      sessionStorage.setItem(this.ALL_REVIEWS_SESSION_KEY, JSON.stringify(this.allReviews));
    }
  }

  getAllReviews(): Review[] {
    return JSON.parse(sessionStorage.getItem(this.ALL_REVIEWS_SESSION_KEY));
  }
}
