/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jeffrey
 * Created: Apr 24, 2018
 */

create table sneakers ( 
        id bigint primary  key not null auto_increment,
        name VARCHAR(250),
        image VARCHAR(300),
        releaseDate VARCHAR (50),
        brand VARCHAR(100),
        model VARCHAR(125),
        sku VARCHAR(125),
        color VARCHAR(50),
        itemCondition VARCHAR(40)
        description VARCHAR(2000)
        );

create table users (
        id bigint primary  key not null auto_increment,
        username VARCHAR (20),
        password VARCHAR (16),
        ); 