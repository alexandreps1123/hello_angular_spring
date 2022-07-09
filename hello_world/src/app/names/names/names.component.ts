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

  name = '';

  displayedColumns = ['name'];

  constructor(private namesService: NamesService) {
    //this.namesService = new NamesService();
    this.names$ = this.namesService.getAllNames()
    .pipe(
      catchError(error => {
        console.log(error);
        return of([]);
      })
    );
  }


  ngOnInit(): void {  }

  onUpdateName(event : any) {
    this.name = (<HTMLInputElement>event.target).value;
  }

  saveName() {

    this.namesService.saveName(this.name);
  }

}
