/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  koxim
 * Created: 2020-7-23
 */
CREATE TABLE book (
   id integer NOT NULL AUTO_INCREMENT,
   title varchar(40) NOT NULL,
   author varchar(40) NOT NULL,
   publisher varchar(40) NOT NULL,
   PRIMARY KEY (`id`)
)
