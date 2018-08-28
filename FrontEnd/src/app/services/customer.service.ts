import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/index';
import {Customer} from '../dtos/customer';
import {HttpClient} from '@angular/common/http';
import {Items} from '../dtos/items';

export const MAIN_URL = 'http://localhost:8080';
const URL = '/api/v1/customers';

@Injectable()
export class CustomerService {

  constructor(private http: HttpClient) { }

  getAllCustomers(): Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>(MAIN_URL + URL);
  }

  deleteCustomer(id: string): Observable<boolean> {
    return this.http.delete<boolean>(MAIN_URL + URL + '/' + id);
  }

  saveCustomer(customer: Customer): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL, customer);
  }

  getTotalCustomers(): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + '/count');
  }

  searchCustomer(id: String): Observable<Customer> {
    return this.http.get<Customer>(MAIN_URL + URL + '/' + id);
  }
}
