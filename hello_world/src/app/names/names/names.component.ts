import { Component, OnInit } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';

import { Names } from '../model/names';
import { NamesService } from '../services/names.service';

@Component({
  selector: 'app-names',
  templateUrl: './names.component.html',
  styleUrls: ['./names.component.css']
})
export class NamesComponent implements OnInit {

  names$: Observable<Names[]>;
  displayedColumns = ['name'];

  //namesService: NamesService;

  constructor(private namesService: NamesService) {
    //this.namesService = new NamesService();
    this.names$ = this.namesService.list()
    .pipe(
      catchError(error => {
        console.log(error);
        return of([]);
      })
    );
  }

  ngOnInit(): void {
  }

}
