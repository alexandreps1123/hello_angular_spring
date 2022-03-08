import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, tap } from 'rxjs';

import { Names } from '../model/names';

@Injectable({
  providedIn: 'root'
})
export class NamesService {

  private readonly API = 'api/names';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Names[]>(this.API)
    .pipe(
      //delay(5000),
      tap(names => console.log(names))
    );
  }
}
