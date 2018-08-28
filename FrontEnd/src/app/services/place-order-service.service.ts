import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {PlaceOrder} from '../dtos/place-order';
import {Observable} from 'rxjs/index';
import {MAIN_URL} from './customer.service';
import {Customer} from '../dtos/customer';
import {Orders} from '../dtos/orders';

const URL = '/api/v1/placeorder';
@Injectable()
export class PlaceOrderServiceService {

  constructor(private http: HttpClient) { }

  placeOrder(placeorders: PlaceOrder): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL, placeorders);
  }

  getAllOrders(): Observable<Array<Orders>> {
    return this.http.get<Array<Orders>>(MAIN_URL + URL);
  }

  getTotalOrders(): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + '/count');
  }
}
