import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, tap, Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

import { Names } from '../model/names';

@Injectable({
  providedIn: 'root'
})
export class NamesService {

  private readonly API = 'api/names';

  constructor(private httpClient: HttpClient) { }

  getAllNames(): Observable<Names[]> {
    return this.httpClient.get<Names[]>(this.API);
  }

  getUpperNames(id: number): Observable<Names> {
    return this.httpClient.get<Names>(`${this.API}/${id}`);
  }

  saveName(data: any): Observable<any> {
    return this.httpClient.post(this.API, data);
  }

}
