SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, '%Y-%m-%d') CREATED_DATE
FROM USED_GOODS_BOARD b join USED_GOODS_REPLY r
ON b.BOARD_ID = r.BOARD_ID
WHERE Year(b.CREATED_DATE) = 2022
AND Month(b.CREATED_DATE) = 10
ORDER BY r.CREATED_DATE, b.TITLE;