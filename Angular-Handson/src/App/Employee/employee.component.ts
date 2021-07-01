import { HtmlParser } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  islogged=true;
  id=3;
  name="john";
  salary=10000;
  permanent="yes";
  skills=[{
    id:1,name:"HTML"
  },{
    id:2,name:"CSS"
  },{
    id:3,name:"JavaScript"
  },{
    id:4,name:"Angular"
  }]
  
 value= new Date('2019-04-21');

  constructor() { }

  ngOnInit(): void {
  }

}
