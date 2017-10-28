-- ACL
INSERT INTO TA_ROLES(NAME) VALUES('READER');
INSERT INTO TA_GROUPS(NAME) VALUES('GUEST');
INSERT INTO TA_GROUPS_AUTHORIZATIONS(ID_GROUP,ID_ROLE) VALUES(1,1);
INSERT INTO TA_USERS(NAME,SURNAME,EMAIL,PASSWORD,BIRTH_DATE,PHONE,ACTIVE,LEGALS,AVATAR,ACCESS_TOKEN,ID_GROUP) VALUES('testUserName','testUserSurname','testUserEmail@sop.fr','testPassword','1988-11-13','0123456789',true,true,'http://avatar.com','token1',1);
INSERT INTO TA_USERS(NAME,SURNAME,EMAIL,PASSWORD,BIRTH_DATE,PHONE,ACTIVE,LEGALS,AVATAR,ACCESS_TOKEN,ID_GROUP) VALUES('testUpdateUserName','testUpdateUserSurname','testUpdateUserEmail@sop.fr','testUpdate','1988-11-14','0123456799',true,true,'http://avatar.com/update','token2',1);
INSERT INTO TA_USERS(NAME,SURNAME,EMAIL,PASSWORD,BIRTH_DATE,PHONE,ACTIVE,LEGALS,AVATAR,ACCESS_TOKEN,ID_GROUP) VALUES('recoverPassUserName','recoverPassUserSurname','recoverPassUserEmail@sop.fr','recoverPass','1988-11-15','0123456794',true,true,'http://avatar.com/recover','token3',1);
INSERT INTO TA_USERS(NAME,SURNAME,EMAIL,PASSWORD,BIRTH_DATE,PHONE,ACTIVE,LEGALS,AVATAR,ACCESS_TOKEN,ID_GROUP) VALUES('signOutUserName','signOutUserSurname','signOutUserEmail@sop.fr','signOut','1988-11-15','0123456794',true,true,'http://avatar.com/signout','token4',1);