CREATE TABLE `cmf_drop_down` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `PARENT_ID` int(11) NOT NULL,
  `ALIAS` varchar(50) DEFAULT NULL,
  `ROUTER` varchar(50) DEFAULT NULL,
  `ICON` varchar(50) DEFAULT 'el-icon-success',
  `PARENT_FLAG` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
