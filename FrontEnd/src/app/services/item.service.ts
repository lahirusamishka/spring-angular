import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {MAIN_URL} from "./customer.service";
import {Items} from "../dtos/items";

const URL="/api/v1/items";

@Injectable()
export class ItemService {

  constructor(private http:HttpClient) {


  }

  getAllItems(): Observable<Array<Items>>{
    return this.http.get<Array<Items>>(MAIN_URL + URL);

  }

  saveItems(item: Items): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL,item);
  }

  deleteCustomer(id: string): Observable<boolean>{
    return this.http.delete<boolean>(MAIN_URL+ URL + "/" + id);
  }

  getTotalItems(): Observable<number>{
    return this.http.get<number>(MAIN_URL + URL + "/count");
  }

  searchItem(code :String): Observable<Items>{
    return this.http.get<Items>(MAIN_URL + URL + "/"+code);
  }

}
