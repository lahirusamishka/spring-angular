import { Component, OnInit } from '@angular/core';
import {PlaceOrderServiceService} from '../../services/place-order-service.service';
import {Orders} from '../../dtos/orders';

@Component({
  selector: 'app-view-orders',
  templateUrl: './view-orders.component.html',
  styleUrls: ['./view-orders.component.css']
})
export class ViewOrdersComponent implements OnInit {
orders: Array<Orders> = [];

  constructor(private placeOrderService: PlaceOrderServiceService) { }

  ngOnInit() {
    this.loadAllArders();
  }

  loadAllArders(): void {
    this.placeOrderService.getAllOrders().subscribe(
      (result) => {
        this.orders = result;
        console.log(this.orders);

      }
    );
  }

}
