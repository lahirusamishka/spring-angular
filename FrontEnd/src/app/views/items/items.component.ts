import {Component, OnInit, ViewChild} from '@angular/core';
import {ItemService} from "../../services/item.service";
import {Customer} from "../../dtos/customer";
import {Items} from "../../dtos/items";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  items: Array<Items> = [];
  selectedItems: Items = new Items;
  tempItems: Items = null;
  manuallySelected: boolean = false;
  @ViewChild("frmItems") frmItems: NgForm;

  constructor(private itemService:ItemService) { }

  ngOnInit() {
    this.loadAllItems();
  }

  loadAllItems(): void {
    this.itemService.getAllItems().subscribe(
      (result) => {
        this.items = result;

        console.log(this.items);
      }
    )
  }

  selectItems(item: Items): void {
    this.clear();
    this.selectedItems = item;
    this.tempItems = Object.assign({}, item);
    this.manuallySelected = true;
  }

  clear(): void {
    let index = this.items.indexOf(this.selectedItems);

    if (index !== -1) {
      this.items[index] = this.tempItems;
      this.tempItems = null;
    }
    this.selectedItems = new Items;
    this.manuallySelected = false;
  }

  saveItems():void{
    this.itemService.saveItems(this.selectedItems).subscribe(
      (result)=> {
        if (result) {
          console.log(this.selectedItems)
          alert("Items has been saved successfully");
          this.loadAllItems();
        } else {
          alert("Failed to save the Items");
        }
      }
    )

  }

  deletItems(itemsID :Items):void {
    if (confirm("Are you sure you want to delete this customer?")) {
      this.itemService.deleteCustomer(itemsID.code).subscribe(
        (result) => {
          if (result) {
            alert("Items has been Deleted successfully");
          } else {
            alert("Failed to deleted Items");
          }
          this.loadAllItems();
        }
      )
    }
  }


}

