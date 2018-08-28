import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../services/customer.service";
import {ItemService} from "../../services/item.service";
import {PlaceOrderServiceService} from "../../services/place-order-service.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  totalCustomers: number = 20;
  totalItems: number;
  totalOrders: number;

  constructor(private placeOrderService:PlaceOrderServiceService,private customerService: CustomerService,private itemService: ItemService) { }

  ngOnInit() {
    this.getTotalCustomers();
    this.getTotalItems();
    this.getTotalOrders();
  }

  getTotalCustomers(): void{
    this.customerService.getTotalCustomers().subscribe(
      (count) =>{
        this.totalCustomers = count;
      }
    )
  }


  getTotalItems(): void {
    this.itemService.getTotalItems().subscribe(
      (count) => {
        this.totalItems = count;
      }
    )
  }

  getTotalOrders():void{
    this.placeOrderService.getTotalOrders().subscribe(
      (result)=>{
        this.totalOrders=result;
      }
    )
  }

}
