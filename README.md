
צֶ'אט - בעברית שִׂיחוּחַ, הוא שיחה כתובה מיידית בין אנשים ברשת האינטרנט. בעולם קיימות מערכות צ'אט רבות, אשר מאפשרות למשתמשים המתחברים לרשת האינטרנט לשוחח אחד עם השני או בקבוצות. פעולה כזאת נקראת בעגת המחשבים העברית לְצ'וֹטֵט.

אני כתבתי צ'אט קבוצתי.
הבעיה הייתה שהצטרפות משתמש לקבוצה וכל ההאזנה להתכתבות שלו היא פעולה אסינכרונית שדורשת פעולה חוסמת ולכן השרת יושב ומאזין וכל התוכנית חסומה. 
ולכן אנו יוצרים תהליכונים שהם ימשיכו לרוץ במקביל לשרת שיושב ומאזין לפניות נוספות.


 
צד שרת – Server side

השרת רץ ברקע ומחכה לפניות.
ברגע שמשתמש מצטרף, השרת פותח לו socket  ושולח אותו ל-thread  . וכל ההתקשרות שלו עם השרת מתבצעת ב-thread זה, כך השרת יכול לתקשר עם כמה לקוחות במקביל.
תהליכונים רצים על אותו מרחב זיכרון ולפיכך יש צורך בהגנה על משתנים משותפים ע"י מנעולים. 
כדי לנעול את רשימת הערוצים הפתוחים (השמורים ברשימת Clients) בעת הוספה, גישה או מחיקה השתמשתי ב- synchronized.



צד לקוח-  Client side

בעת יצירת לקוח חדש הלקוח רץ ברקע ומאזין לקריאות חדשות מהשרת
בכדי להאזין להודעות שמתקבלות מהמשתמשים האחרים ובמקביל לטפל בכתיבת ההודעות לשרת, נעזר בthread נוסף בשם client שהוא מאזין להודעות חדשות מהשרת.

דוגמה להרצה - -


