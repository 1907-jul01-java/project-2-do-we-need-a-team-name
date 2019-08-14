import { Component, Input, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import { MoviedetailsService } from '../moviedetails.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-moviedetails',
  templateUrl: './moviedetails.component.html',
  styleUrls: ['./moviedetails.component.css']
})
export class MoviedetailsComponent implements OnInit {
  @Input() movie;
  constructor(private config: ConfigService, private details: MoviedetailsService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.movie = this.route.snapshot.paramMap.get("movie");
  }
  displayMovie(id) {
    this.details.getMovie(id).subscribe((response) => { this.movie = response; });
  }

  // displayMovie(title) {
  //   this.details.getTitle(title).subscribe((response) => { this.movie = response; });
  // }

}
