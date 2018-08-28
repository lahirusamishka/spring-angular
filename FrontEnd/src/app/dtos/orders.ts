import {Customer} from './customer';

export class Orders {
  oId: string;
  date: string;
  totalPrice: number;
  customer: Customer;


  constructor(oId: string, date: string, totalPrice: number, customer: Customer) {
    this.oId = oId;
    this.date = date;
    this.totalPrice = totalPrice;
    this.customer = customer;
  }
}
