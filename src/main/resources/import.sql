insert into Subscriber (subscriberid, firstname, lastname, email, password) values (SUBSCRIBER_SEQ.nextval, 'stevie', 'ripley', 'stevie@email.com','1');

insert into Artist (artistid, firstname, lastname, styletype, email, password, socialmedia) values (ARTIST_SEQ.nextval, 'john', 'smith', 'BRIDAL', 'johnsmith@email.com', '2', 'Instagram: @JSMUA');
insert into Artist (artistid, firstname, lastname, styletype, email, password, socialmedia) values (ARTIST_SEQ.nextval, 'big', 'shaq', 'THEATRICAL', 'mansnothot@email.com', 'nothot', 'Facebook @BigShaq');

insert into TheatricalStyle (makeupstyleid, name, description, theme, products, completiontime, tutorial, rating, artistid) values (MAKEUPSTYLE_SEQ.nextval, 'Skeleton', 'bones and stuff', 'halloween', 'b/w paint', 45, 'tutorialstuff', 3, 1);
insert into TheatricalStyle (makeupstyleid, name, description, theme, products, completiontime, tutorial, rating, artistid) values (MAKEUPSTYLE_SEQ.nextval, 'Pirate', 'pirate makeupf', 'halloween', 'fake beard paint', 50, 'tutorial', 4, 2);

insert into BridalStyle (makeupstyleid, name, description, colourscheme, products, completiontime, tutorial, rating, artistid) values (MAKEUPSTYLE_SEQ.nextval, 'Summer1', 'For summer wedding', 'Gold/Orange', 'f,e,l,p,t', 120, 'do a tutorial', 4, 1);
insert into BridalStyle (makeupstyleid, name, description, colourscheme, products, completiontime, tutorial, rating, artistid) values (MAKEUPSTYLE_SEQ.nextval, 'Spring1', 'For spring wedding', 'Yellow/silver', 'foundation', 110, 'do something', 5, 1);

insert into NaturalStyle (makeupstyleid, name, description, colourscheme, products, completiontime, tutorial, rating, artistid) values (MAKEUPSTYLE_SEQ.nextval, 'QuickMorning', 'Fast morning look', 'Brown/Nude', 'products', 15, 'tutorialthings' ,5 ,2);
insert into NaturalStyle (makeupstyleid, name, description, colourscheme, products, completiontime, tutorial, rating, artistid) values (MAKEUPSTYLE_SEQ.nextval, 'FullMorning', 'Full morning look', 'Brown/Nude/Gold', 'products123', 45, 'doathing' ,4 ,2);