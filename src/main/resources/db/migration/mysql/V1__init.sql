
    create table account (
       id bigint not null,
        account integer not null,
        agency integer not null,
        bank varchar(255) not null,
        password varchar(255) not null,
        person_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table card (
       id bigint not null,
        expire_date datetime not null,
        nickname varchar(255) not null,
        number integer not null,
        account_id bigint,
        purchase_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table classification (
       id bigint not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    create table nota_fiscal (
       id bigint not null,
        credit float,
        credit_situation float,
        establishment_cnpj varchar(255) not null,
        establishment_name varchar(255) not null,
        issued_date date not null,
        num_nota integer not null,
        registation_date date,
        value float not null,
        purchase_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table person (
       id bigint not null,
        cpf varchar(255) not null,
        email varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        perfil varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table product (
       id bigint not null,
        code integer not null,
        description varchar(255) not null,
        item_value float not null,
        num_order integer not null,
        quantity float not null,
        unit varchar(255) not null,
        unit_value float not null,
        nota_fiscal_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table purchase (
       id bigint not null,
        current_installment integer,
        date_time datetime not null,
        payment_method varchar(255),
        payment_type varchar(255),
        price float not null,
        purchase varchar(255) not null,
        total_num_of_installment integer,
        account_id bigint,
        card_id bigint,
        classification_id bigint,
        nota_fiscal_id bigint,
        person_id bigint,
        sub_classification_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table subclassification (
       id bigint not null,
        name varchar(255) not null,
        classification_id bigint,
        primary key (id)
    ) engine=InnoDB;

-- AUTO_INCREMENT for tables ---------------------------
    ALTER TABLE account
       MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

    ALTER TABLE card
       MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

    ALTER TABLE classification
       MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

    ALTER TABLE nota_fiscal
       MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

    ALTER TABLE person
       MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

    ALTER TABLE product
       MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

    ALTER TABLE purchase
       MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

    ALTER TABLE subclassification
       MODIFY id bigint(20) NOT NULL AUTO_INCREMENT;

--------------------------------------------------------

    alter table account 
       add constraint FKd9dhia7smrg88vcbiykhofxee 
       foreign key (person_id) 
       references person (id);

    alter table card 
       add constraint FK8v67eys6tqflsm6hrdgru2phu 
       foreign key (account_id) 
       references account (id);

    alter table card 
       add constraint FK4hcaobpmu73sm26in8ps8e66b 
       foreign key (purchase_id) 
       references purchase (id);

    alter table nota_fiscal 
       add constraint FK24np7how8rbauq2sl0h6e7fek 
       foreign key (purchase_id) 
       references purchase (id);

    alter table product 
       add constraint FKm4h2o831llxou04sy4ihmmueo 
       foreign key (nota_fiscal_id) 
       references nota_fiscal (id);

    alter table purchase 
       add constraint FKj4nqpwiw7s85ps78eghvnlaeh 
       foreign key (account_id) 
       references account (id);

    alter table purchase 
       add constraint FKffufn6rsw80t2iordi80a0dqg 
       foreign key (card_id) 
       references card (id);

    alter table purchase 
       add constraint FKq2axuqihevggdm3i7gwb7ani8 
       foreign key (classification_id) 
       references classification (id);

    alter table purchase 
       add constraint FKjw8rilduh4xea3rmpa8xxldq6 
       foreign key (nota_fiscal_id) 
       references nota_fiscal (id);

    alter table purchase 
       add constraint FKhm49vmno151fip5gw8cs85s8j 
       foreign key (person_id) 
       references person (id);

    alter table purchase 
       add constraint FKn3sj97ytfjiio2roeiqjay716 
       foreign key (sub_classification_id) 
       references subclassification (id);

    alter table subclassification 
       add constraint FK95nl0scfm9i1q9anwqmf318ry 
       foreign key (classification_id) 
       references classification (id);
