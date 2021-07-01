import {Component, OnInit} from '@angular/core';
import {Paper} from '../paper';
import {PaperService} from './paper.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-pcmember',
  templateUrl: './pcmember.component.html',
  styleUrls: ['./pcmember.component.css']
})
export class PcmemberComponent implements OnInit {

  papersForBidding: Paper[];
  papersAssignedForReviewing: Paper[];

  constructor(public paperService: PaperService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.papersForBidding = [];
    this.papersAssignedForReviewing = [];


    this.paperService.getAllPapers()
      .subscribe(papers => this.papersForBidding = papers);
    console.log(this.papersForBidding);
  }

  bidPaper(paper: Paper): void {
    this.papersAssignedForReviewing.push(paper);
  }

  reviewPaper(paper: Paper): void {
    console.log(paper);
    const route = this.router.config.find(r => r.path === 'review');
    route.data = {paper};
    this.router.navigate(['/review']);
  }
}
