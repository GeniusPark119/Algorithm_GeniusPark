SELECT BOD.TITLE, BOD.BOARD_ID, REPLY_ID, REP.WRITER_ID, REP.CONTENTS, DATE_FORMAT( REP.CREATED_DATE,'%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_REPLY AS REP JOIN USED_GOODS_BOARD AS BOD
ON BOD.BOARD_ID = REP.BOARD_ID
WHERE BOD.CREATED_DATE BETWEEN '2022-10-01' AND '2022-10-31'
ORDER BY REP.CREATED_DATE, BOD.TITLE