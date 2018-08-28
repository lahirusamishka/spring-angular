import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {CustomerService} from '../../services/customer.service';
import {Customer} from '../../dtos/customer';
import {ItemService} from '../../services/item.service';
import {Items} from '../../dtos/items';
import {NgForm} from '@angular/forms';
import {Orders} from '../../dtos/orders';
import {OrdersDetailPK} from '../../dtos/orders-detail-pk';
import {OrdersDetail} from '../../dtos/orders-detail';
import {PlaceOrder} from '../../dtos/place-order';
import {PlaceOrderServiceService} from '../../services/place-order-service.service';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {

  customers: Array<Customer> = [];
  selectedItems: Array<OrdersDetail> = [];
  FullTotal = 0;
  serchedItems: Items = new Items();
  serchedCustomers: Customer = new Customer();
  orderDetail_PKDto: OrdersDetailPK;
  orderDetail: OrdersDetail;
  items: any = [];
  placeOrder: PlaceOrder;
  orders: Orders;
  Total = 0;
  @ViewChild('frmItems') frmItems: NgForm;

  constructor(private placeOrderService: PlaceOrderServiceService, private customerService: CustomerService , private itemService: ItemService, private elem: ElementRef) { }

  ngOnInit() {
    this.getCustomerId();
    this.getItemCode();
  }

  getCustomerId(): void {
    this.customerService.getAllCustomers().subscribe(
      (result) => {
        this.customers = result;
        console.log(this.customers);
      }
    );

  }


  searchItems(event: any): void {
    this.itemService.searchItem(event.target.value).subscribe(
      (result) => {
        this.serchedItems = result;
        console.log(this.serchedItems);
      }
    );

  }

  getItemCode() {
    this.itemService.getAllItems().subscribe(
      (result) => {
        this.items = result;
      }
    );
  }

  SelectOrderDetails(): void {

    const orderDate = this.elem.nativeElement.querySelector('#orderDate').value;
    const qty = this.elem.nativeElement.querySelector('#qty').value;
    const orderId = this.elem.nativeElement.querySelector('#orderid').value;

    this.Total = qty * this.serchedItems.unicPrice;
    this.FullTotal = this.FullTotal + this.Total;
    const price = this.FullTotal;
    console.log(price);

    this.orders = new Orders(orderId, orderDate, this.Total, this.serchedCustomers);
    console.log(this.orders.totalPrice);
    this.orderDetail_PKDto = new OrdersDetailPK();
    this.orderDetail = new OrdersDetail();
    this.orderDetail.quantity = qty;
    this.orderDetail.unitprice = this.serchedItems.unicPrice;
    this.orderDetail.item = this.serchedItems;
    this.orderDetail.orders = this.orders;
    this.orderDetail.orderDetail_PKDto = this.orderDetail_PKDto;

    this.selectedItems.push(this.orderDetail);

    console.log(this.selectedItems);
  }

  searchCustomer(event: any): void {
    this.customerService.searchCustomer(event.target.value).subscribe(
      (result) => {
        this.serchedCustomers = result;
        console.log(this.serchedItems);
      }
    );
  }
  addOrder(): void {
    this.placeOrder = new PlaceOrder();
    this.placeOrder.itemsDTO = this.serchedItems;
    this.placeOrder.orderDTO = this.orders;
    this.placeOrder.orderDetailDTOS = this.selectedItems;

    this.placeOrderService.placeOrder(this.placeOrder).subscribe(
      (result) => {
        if (result) {
          alert('Order has been saved successfully');
        } else {
          alert('Failed to save the Order');
        }
      }
    );


  }
}
