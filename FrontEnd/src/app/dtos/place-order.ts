import {Items} from "./items";
import {Orders} from "./orders";
import {OrdersDetail} from "./orders-detail";

export class PlaceOrder {
  itemsDTO:Items;
  orderDTO:Orders;
  orderDetailDTOS:Array<OrdersDetail>;

}
