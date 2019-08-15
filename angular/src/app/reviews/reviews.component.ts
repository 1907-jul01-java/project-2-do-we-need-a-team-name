import { Component, OnInit, Input } from '@angular/core';
import { MoviedetailsService } from '../moviedetails.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {
@Input() movie;
reviews;
avgScore;
numReviews;
  constructor(private MoviedetailsService: MoviedetailsService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.movie = this.route.snapshot.paramMap.get("movie");
    this.MoviedetailsService.getReviews(this.movie).subscribe(response => {
      this.reviews = response["results"];
      console.log(this.reviews);
    });

    this.MoviedetailsService.getMovie(this.movie).subscribe(response => {
      this.avgScore = response["vote_average"];
      this.numReviews = response["vote_count"];
    });
  }

}
