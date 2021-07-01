import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs';
import {Paper} from '../../paper';
import {FormBuilder, Validators} from '@angular/forms';
import {Review} from './review';
import {ReviewService} from './review.service';

@Component({
  selector: 'app-review-paper',
  templateUrl: './review-paper.component.html',
  styleUrls: ['./review-paper.component.css']
})
export class ReviewPaperComponent implements OnInit {
  possibleReviewValues: any = ['reject', 'accept'];
  selectedPaper: Paper;
  selectedReviewValue: string;
  gradingForm = this.formBuilder.group({
    grade: ['', [Validators.required]],
    comments: ['']
  });
  allReviews: Review[] = [];

  constructor(private route: ActivatedRoute,
              public formBuilder: FormBuilder,
              public reviewService: ReviewService) {
  }

  ngOnInit(): void {
    this.selectedPaper = this.route.snapshot.data[`paper`];
  }

  changeSelectedReviewValue(value: any): void {
    console.log(this.possibleReviewValues);
    this.selectedReviewValue = value;
  }

  onSubmit(): void {
    this.reviewService.addReview(
      new Review(
        this.gradingForm.value[`grade`],
        this.selectedPaper.title,
        this.gradingForm.value[`comments`]
      )
    );

    this.allReviews = this.reviewService.getAllReviews();
    console.log(this.allReviews);
  }
}
