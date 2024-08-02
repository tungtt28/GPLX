package com.example.project.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.project.Models.Answer;
import com.example.project.Models.Question;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

@Database(entities = {Question.class, Answer.class}, version = 2)
public abstract class QuizDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "quiz_database";
    private static volatile QuizDatabase instance;

    public static synchronized QuizDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            QuizDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()  // Thêm dòng này
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Executors.newSingleThreadExecutor().execute(() -> {
                                populateInitialData(getInstance(context));
                            });
                        }
                    })
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


    public abstract QuizDao quizDao();

    public static void populateInitialData(final QuizDatabase db) {
        QuizDao quizDao = db.quizDao();

        Question question1 = new Question("Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?", 1, "Đề 1");
        long questionId1 = quizDao.insertQuestion(question1);
        List<Answer> answers1 = Arrays.asList(
                new Answer((int) questionId1, "Phần mặt đường và lề đường.", false),
                new Answer((int) questionId1, "Phần đường xe chạy.", true),
                new Answer((int) questionId1, "Phần đường xe cơ giới.", false),
                new Answer((int) questionId1, "Phần đường xe ô tô và xe máy.", false)
        );
        quizDao.insertAnswers(answers1);

        Question question2 = new Question("“Phương tiện tham gia giao thông đường bộ” gồm những loại nào?", 2, "Đề 1");
        long questionId2 = quizDao.insertQuestion(question2);
        List<Answer> answers2 = Arrays.asList(
                new Answer((int) questionId2, "Phương tiện giao thông cơ giới đường bộ.", false),
                new Answer((int) questionId2, "Cả ý 1 và ý 2.", true),
                new Answer((int) questionId2, "Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.", false),
                new Answer((int) questionId2, "Không có ý nào đúng.", false)
        );
        quizDao.insertAnswers(answers2);

        Question question3 = new Question("* Sử dụng rượu bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào?", 3, "Đề 1");
        long questionId3 = quizDao.insertQuestion(question3);
        List<Answer> answers3 = Arrays.asList(
                new Answer((int) questionId3, "Chỉ bị nhắc nhở.", false),
                new Answer((int) questionId3, "Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm.", true),
                new Answer((int) questionId3, "Không bị xử lý hình sự.", false),
                new Answer((int) questionId3, "Bị xử phạt hành chính.", false)
        );
        quizDao.insertAnswers(answers3);

        // Thêm nhiều câu hỏi và câu trả lời khác ở đây nếu cần thiết
        Question question4 = new Question("Bạn đang lái xe phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không?", 4, "Đề 1");
        long questionId4 = quizDao.insertQuestion(question4);
        List<Answer> answers4 = Arrays.asList(
                new Answer((int) questionId4, "Không được vượt.", true),
                new Answer((int) questionId4, "Được vượt khi đang đi trên cầu.", false),
                new Answer((int) questionId4, "Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông.", false),
                new Answer((int) questionId4, "Được vượt khi đảm bảo an toàn.", false)
        );
        quizDao.insertAnswers(answers4);

        Question question5 = new Question("* Hành vi sử dụng xe mô tô để kéo, đẩy xe mô tô khác bị hết xăng đến trạm mua xăng có được phép hay không?", 5, "Đề 1");
        long questionId5 = quizDao.insertQuestion(question5);
        List<Answer> answers5 = Arrays.asList(
                new Answer((int) questionId5, "Chỉ được kéo nếu đã nhìn thấy trạm xăng.", false),
                new Answer((int) questionId5, "Chỉ được thực hiện trên đường vắng phương tiện cùng tham gia giao thông.", false),
                new Answer((int) questionId5, "Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.", true),
                new Answer((int) questionId5, "Không có ý nào đúng.", false)
        );
        quizDao.insertAnswers(answers5);

        Question question6 = new Question("Bạn đang lái xe trong khu vực đô thị từ 22 giờ đến 5 giờ sáng hôm sau và cần vượt một xe khác, bạn cần báo hiệu như thế nào để đảm bảo an toàn giao thông?", 6, "Đề 1");
        long questionId6 = quizDao.insertQuestion(question6);
        List<Answer> answers6 = Arrays.asList(
                new Answer((int) questionId6, "Phải báo hiệu bằng đèn hoặc còi;", false),
                new Answer((int) questionId6, "Chỉ được báo hiệu bằng còi.", false),
                new Answer((int) questionId6, "Phải báo hiệu bằng cả còi và đèn.", false),
                new Answer((int) questionId6, "Chỉ được báo hiệu bằng đèn.", true)
        );
        quizDao.insertAnswers(answers6);
        Question question7 = new Question("Khi điều khiển xe mô tô tay ga xuống đường dốc dài, người lái xe nên thực hiện thao tác nào để đảm bảo an toàn?", 7, "Đề 1");
        long questionId7 = quizDao.insertQuestion(question7);
        List<Answer> answers7 = Arrays.asList(
                new Answer((int) questionId7, "Giữ tay ga ở mức độ vừa phải, sử dụng phanh trước và phanh sau để giảm tốc độ.", true),
                new Answer((int) questionId7, "Tắt máy, đi xe tự do xuống dốc.", false),
                new Answer((int) questionId7, "Sử dụng phanh trước.", false),
                new Answer((int) questionId7, "Sử dụng phanh sau.", false)
        );
        quizDao.insertAnswers(answers7);

        Question question8 = new Question("Khi có tín hiệu của xe ưu tiên, người tham gia giao thông phải làm gì?", 8, "Đề 1");
        long questionId8 = quizDao.insertQuestion(question8);
        List<Answer> answers8 = Arrays.asList(
                new Answer((int) questionId8, "Nhanh chóng giảm tốc độ và tránh đường cho xe ưu tiên.", true),
                new Answer((int) questionId8, "Tiếp tục đi vì xe ưu tiên phải tự tìm cách vượt qua.", false),
                new Answer((int) questionId8, "Giảm tốc độ nhưng không cần tránh đường.", false),
                new Answer((int) questionId8, "Đi sát vào lề đường và nhường đường khi an toàn.", false)
        );
        quizDao.insertAnswers(answers8);

        Question question9 = new Question("Tốc độ tối đa cho phép khi đi trên đường cao tốc là bao nhiêu?", 9, "Đề 1");
        long questionId9 = quizDao.insertQuestion(question9);
        List<Answer> answers9 = Arrays.asList(
                new Answer((int) questionId9, "80 km/h.", false),
                new Answer((int) questionId9, "100 km/h.", false),
                new Answer((int) questionId9, "120 km/h.", true),
                new Answer((int) questionId9, "90 km/h.", false)
        );
        quizDao.insertAnswers(answers9);

        Question question10 = new Question("Biển báo nào có hiệu lực cảnh báo các nguy hiểm trên đường?", 10, "Đề 1");
        long questionId10 = quizDao.insertQuestion(question10);
        List<Answer> answers10 = Arrays.asList(
                new Answer((int) questionId10, "Biển báo chỉ dẫn.", false),
                new Answer((int) questionId10, "Biển báo nguy hiểm.", true),
                new Answer((int) questionId10, "Biển báo cấm.", false),
                new Answer((int) questionId10, "Biển báo hiệu lệnh.", false)
        );
        quizDao.insertAnswers(answers10);

        Question question11 = new Question("Tại nơi giao nhau có vòng xuyến, người điều khiển phương tiện phải nhường đường như thế nào?", 11, "Đề 1");
        long questionId11 = quizDao.insertQuestion(question11);
        List<Answer> answers11 = Arrays.asList(
                new Answer((int) questionId11, "Nhường đường cho xe đi bên phải.", false),
                new Answer((int) questionId11, "Nhường đường cho xe đi bên trái.", false),
                new Answer((int) questionId11, "Nhường đường cho xe đi ở phía đối diện.", false),
                new Answer((int) questionId11, "Nhường đường cho xe đi từ bất kỳ hướng nào đến.", true)
        );
        quizDao.insertAnswers(answers11);

        Question question12 = new Question("Khi nào thì xe mô tô được phép đi vào phần đường dành cho người đi bộ?", 12, "Đề 1");
        long questionId12 = quizDao.insertQuestion(question12);
        List<Answer> answers12 = Arrays.asList(
                new Answer((int) questionId12, "Khi không có người đi bộ trên đường.", false),
                new Answer((int) questionId12, "Khi có cảnh sát giao thông điều khiển.", false),
                new Answer((int) questionId12, "Khi cần tránh chướng ngại vật trên đường.", false),
                new Answer((int) questionId12, "Không bao giờ được phép.", true)
        );
        quizDao.insertAnswers(answers12);

        Question question13 = new Question("Khi điều khiển xe trên đường vòng, người lái xe phải làm gì?", 13, "Đề 1");
        long questionId13 = quizDao.insertQuestion(question13);
        List<Answer> answers13 = Arrays.asList(
                new Answer((int) questionId13, "Giảm tốc độ, đi đúng phần đường của mình và chỉ được chuyển hướng khi có tín hiệu báo rẽ.", true),
                new Answer((int) questionId13, "Tăng tốc độ và vượt xe khác.", false),
                new Answer((int) questionId13, "Đi chậm và dừng lại.", false),
                new Answer((int) questionId13, "Đi theo xe trước để tránh bị vượt.", false)
        );
        quizDao.insertAnswers(answers13);

        Question question14 = new Question("Người điều khiển xe phải giảm tốc độ và dừng lại khi nào?", 14, "Đề 1");
        long questionId14 = quizDao.insertQuestion(question14);
        List<Answer> answers14 = Arrays.asList(
                new Answer((int) questionId14, "Khi có tín hiệu đèn xanh.", false),
                new Answer((int) questionId14, "Khi có đèn báo nguy hiểm phía trước.", false),
                new Answer((int) questionId14, "Khi có đèn đỏ hoặc có người điều khiển giao thông ra tín hiệu dừng lại.", true),
                new Answer((int) questionId14, "Khi thấy đường rộng rãi.", false)
        );
        quizDao.insertAnswers(answers14);

        Question question15 = new Question("Khi điều khiển xe qua đường sắt, người lái xe phải thực hiện thao tác nào để đảm bảo an toàn?", 15, "Đề 1");
        long questionId15 = quizDao.insertQuestion(question15);
        List<Answer> answers15 = Arrays.asList(
                new Answer((int) questionId15, "Quan sát cả hai phía, đi nhanh qua đường sắt.", false),
                new Answer((int) questionId15, "Dừng lại, quan sát và chỉ đi khi đảm bảo an toàn.", true),
                new Answer((int) questionId15, "Giảm tốc độ và đi từ từ qua đường sắt.", false),
                new Answer((int) questionId15, "Đi nhanh nếu thấy không có tàu đến.", false)
        );
        quizDao.insertAnswers(answers15);

        Question question16 = new Question("Người điều khiển phương tiện tham gia giao thông phải tuân thủ theo hiệu lệnh của ai?", 16, "Đề 1");
        long questionId16 = quizDao.insertQuestion(question16);
        List<Answer> answers16 = Arrays.asList(
                new Answer((int) questionId16, "Người điều khiển phương tiện khác.", false),
                new Answer((int) questionId16, "Cảnh sát giao thông và các loại biển báo, đèn tín hiệu.", true),
                new Answer((int) questionId16, "Người tham gia giao thông khác.", false),
                new Answer((int) questionId16, "Tất cả các ý trên.", false)
        );
        quizDao.insertAnswers(answers16);

        Question question17 = new Question("Khi đèn tín hiệu chuyển sang màu vàng, người điều khiển phương tiện phải làm gì?", 17, "Đề 1");
        long questionId17 = quizDao.insertQuestion(question17);
        List<Answer> answers17 = Arrays.asList(
                new Answer((int) questionId17, "Tiếp tục đi vì màu vàng không có ý nghĩa gì.", false),
                new Answer((int) questionId17, "Dừng lại trước vạch dừng xe, trừ trường hợp đã đi quá vạch dừng xe thì được đi tiếp.", true),
                new Answer((int) questionId17, "Nhanh chóng tăng tốc độ để vượt qua ngã tư.", false),
                new Answer((int) questionId17, "Giảm tốc độ và tiếp tục đi.", false)
        );
        quizDao.insertAnswers(answers17);

        Question question18 = new Question("Khi tham gia giao thông trên đường cao tốc, người lái xe phải tuân thủ quy định nào sau đây?", 18, "Đề 1");
        long questionId18 = quizDao.insertQuestion(question18);
        List<Answer> answers18 = Arrays.asList(
                new Answer((int) questionId18, "Điều khiển xe ở tốc độ tối đa và tối thiểu theo quy định.", true),
                new Answer((int) questionId18, "Điều khiển xe với tốc độ chậm để quan sát.", false),
                new Answer((int) questionId18, "Điều khiển xe với tốc độ nhanh hơn quy định.", false),
                new Answer((int) questionId18, "Điều khiển xe theo tốc độ của xe trước.", false)
        );
        quizDao.insertAnswers(answers18);

        Question question19 = new Question("Khi điều khiển xe trong khu vực đô thị từ 22 giờ đến 5 giờ sáng hôm sau, người lái xe phải thực hiện điều gì để đảm bảo an toàn giao thông?", 19, "Đề 1");
        long questionId19 = quizDao.insertQuestion(question19);
        List<Answer> answers19 = Arrays.asList(
                new Answer((int) questionId19, "Đi với tốc độ nhanh để tránh va chạm.", false),
                new Answer((int) questionId19, "Đi chậm và dùng đèn chiếu xa.", false),
                new Answer((int) questionId19, "Đi chậm và dùng đèn chiếu gần.", true),
                new Answer((int) questionId19, "Đi với tốc độ bình thường.", false)
        );
        quizDao.insertAnswers(answers19);

        Question question20 = new Question("Khi có tín hiệu của xe cảnh sát giao thông, người điều khiển phương tiện phải làm gì?", 20, "Đề 1");
        long questionId20 = quizDao.insertQuestion(question20);
        List<Answer> answers20 = Arrays.asList(
                new Answer((int) questionId20, "Tiếp tục đi vì xe cảnh sát phải tự tìm cách vượt qua.", false),
                new Answer((int) questionId20, "Nhanh chóng giảm tốc độ và tránh đường cho xe cảnh sát.", true),
                new Answer((int) questionId20, "Đi sát vào lề đường và nhường đường khi an toàn.", false),
                new Answer((int) questionId20, "Giảm tốc độ nhưng không cần tránh đường.", false)
        );
        quizDao.insertAnswers(answers20);

        // Question 1
        Question question21 = new Question("Phần nào của đường bộ dành riêng cho người đi bộ?", 1, "Đề 2");
        long questionId21 = quizDao.insertQuestion(question21);
        List<Answer> answers21 = Arrays.asList(
                new Answer((int) questionId21, "Làn đường.", false),
                new Answer((int) questionId21, "Vỉa hè.", true),
                new Answer((int) questionId21, "Lề đường.", false),
                new Answer((int) questionId21, "Dải phân cách.", false)
        );
        quizDao.insertAnswers(answers21);

// Question 2
        Question question22 = new Question("Khi gặp biển báo hình tam giác vàng viền đỏ, bạn phải làm gì?", 2, "Đề 2");
        long questionId22 = quizDao.insertQuestion(question22);
        List<Answer> answers22 = Arrays.asList(
                new Answer((int) questionId22, "Dừng lại.", false),
                new Answer((int) questionId22, "Giảm tốc độ, chú ý quan sát.", true),
                new Answer((int) questionId22, "Đi nhanh hơn.", false),
                new Answer((int) questionId22, "Bỏ qua.", false)
        );
        quizDao.insertAnswers(answers22);

// Question 3
        Question question23 = new Question("Khi đèn tín hiệu giao thông chuyển sang màu đỏ, bạn phải làm gì?", 3, "Đề 2");
        long questionId23 = quizDao.insertQuestion(question23);
        List<Answer> answers23 = Arrays.asList(
                new Answer((int) questionId23, "Giảm tốc độ và tiếp tục đi.", false),
                new Answer((int) questionId23, "Dừng lại trước vạch dừng.", true),
                new Answer((int) questionId23, "Đi nhanh qua ngã tư.", false),
                new Answer((int) questionId23, "Nhìn tín hiệu của người đi bộ.", false)
        );
        quizDao.insertAnswers(answers23);

// Question 4
        Question question24 = new Question("Khi lái xe vào ban đêm, bạn cần sử dụng đèn nào để đảm bảo an toàn?", 4, "Đề 2");
        long questionId24 = quizDao.insertQuestion(question24);
        List<Answer> answers24 = Arrays.asList(
                new Answer((int) questionId24, "Đèn chiếu gần.", true),
                new Answer((int) questionId24, "Đèn chiếu xa.", false),
                new Answer((int) questionId24, "Đèn pha.", false),
                new Answer((int) questionId24, "Đèn xi nhan.", false)
        );
        quizDao.insertAnswers(answers24);

// Question 5
        Question question25 = new Question("Khi lái xe trên đường cao tốc, khoảng cách an toàn giữa các xe phải như thế nào?", 5, "Đề 2");
        long questionId25 = quizDao.insertQuestion(question25);
        List<Answer> answers25 = Arrays.asList(
                new Answer((int) questionId25, "30m.", false),
                new Answer((int) questionId25, "50m.", true),
                new Answer((int) questionId25, "10m.", false),
                new Answer((int) questionId25, "100m.", false)
        );
        quizDao.insertAnswers(answers25);

// Question 6
        Question question26 = new Question("Khi nào bạn được phép vượt xe khác?", 6, "Đề 2");
        long questionId26 = quizDao.insertQuestion(question26);
        List<Answer> answers26 = Arrays.asList(
                new Answer((int) questionId26, "Khi có tín hiệu cho phép vượt.", true),
                new Answer((int) questionId26, "Khi đang đi qua cầu.", false),
                new Answer((int) questionId26, "Khi xe phía trước đi chậm.", false),
                new Answer((int) questionId26, "Khi đường trống.", false)
        );
        quizDao.insertAnswers(answers26);

// Question 7
        Question question27 = new Question("Khi lái xe vào ban ngày, đèn nào phải được bật?", 7, "Đề 2");
        long questionId27 = quizDao.insertQuestion(question27);
        List<Answer> answers27 = Arrays.asList(
                new Answer((int) questionId27, "Đèn pha.", false),
                new Answer((int) questionId27, "Đèn chiếu xa.", false),
                new Answer((int) questionId27, "Đèn ban ngày.", true),
                new Answer((int) questionId27, "Đèn xi nhan.", false)
        );
        quizDao.insertAnswers(answers27);

// Question 8
        Question question28 = new Question("Khi gặp biển báo cấm dừng, bạn phải làm gì?", 8, "Đề 2");
        long questionId28 = quizDao.insertQuestion(question28);
        List<Answer> answers28 = Arrays.asList(
                new Answer((int) questionId28, "Dừng lại.", false),
                new Answer((int) questionId28, "Tiếp tục đi.", true),
                new Answer((int) questionId28, "Dừng lại một lúc rồi đi tiếp.", false),
                new Answer((int) questionId28, "Đi chậm.", false)
        );
        quizDao.insertAnswers(answers28);

// Question 9
        Question question29 = new Question("Khi điều khiển xe mô tô, bạn phải đội mũ bảo hiểm khi nào?", 9, "Đề 2");
        long questionId29 = quizDao.insertQuestion(question29);
        List<Answer> answers29 = Arrays.asList(
                new Answer((int) questionId29, "Khi đi trên đường cao tốc.", false),
                new Answer((int) questionId29, "Khi đi trong đô thị.", false),
                new Answer((int) questionId29, "Khi đi trên đường giao thông công cộng.", true),
                new Answer((int) questionId29, "Khi đi vào buổi tối.", false)
        );
        quizDao.insertAnswers(answers29);

// Question 10
        Question question30 = new Question("Người điều khiển xe ô tô có được phép sử dụng điện thoại khi đang lái xe không?", 10, "Đề 2");
        long questionId30 = quizDao.insertQuestion(question30);
        List<Answer> answers30 = Arrays.asList(
                new Answer((int) questionId30, "Được phép sử dụng.", false),
                new Answer((int) questionId30, "Không được phép sử dụng.", true),
                new Answer((int) questionId30, "Chỉ được sử dụng khi có tai nghe.", false),
                new Answer((int) questionId30, "Chỉ được sử dụng khi đường trống.", false)
        );
        quizDao.insertAnswers(answers30);

// Question 11
        Question question31 = new Question("Biển báo nào có hiệu lực cảnh báo các nguy hiểm trên đường?", 11, "Đề 2");
        long questionId31 = quizDao.insertQuestion(question31);
        List<Answer> answers31 = Arrays.asList(
                new Answer((int) questionId31, "Biển báo chỉ dẫn.", false),
                new Answer((int) questionId31, "Biển báo nguy hiểm.", true),
                new Answer((int) questionId31, "Biển báo cấm.", false),
                new Answer((int) questionId31, "Biển báo hiệu lệnh.", false)
        );
        quizDao.insertAnswers(answers31);

// Question 12
        Question question32 = new Question("Khi có tín hiệu của xe cứu hỏa, người tham gia giao thông phải làm gì?", 12, "Đề 2");
        long questionId32 = quizDao.insertQuestion(question32);
        List<Answer> answers32 = Arrays.asList(
                new Answer((int) questionId32, "Nhanh chóng giảm tốc độ và tránh đường cho xe cứu hỏa.", true),
                new Answer((int) questionId32, "Tiếp tục đi vì xe cứu hỏa phải tự tìm cách vượt qua.", false),
                new Answer((int) questionId32, "Giảm tốc độ nhưng không cần tránh đường.", false),
                new Answer((int) questionId32, "Đi sát vào lề đường và nhường đường khi an toàn.", false)
        );
        quizDao.insertAnswers(answers32);

// Question 13
        Question question33 = new Question("Người điều khiển xe phải làm gì khi gặp biển báo cấm?", 13, "Đề 2");
        long questionId33 = quizDao.insertQuestion(question33);
        List<Answer> answers33 = Arrays.asList(
                new Answer((int) questionId33, "Dừng lại.", false),
                new Answer((int) questionId33, "Tuân thủ theo nội dung của biển báo.", true),
                new Answer((int) questionId33, "Tiếp tục đi.", false),
                new Answer((int) questionId33, "Giảm tốc độ.", false)
        );
        quizDao.insertAnswers(answers33);

// Question 14
        Question question34 = new Question("Khi điều khiển xe qua nơi giao nhau có đèn tín hiệu, người lái xe phải làm gì?", 14, "Đề 2");
        long questionId34 = quizDao.insertQuestion(question34);
        List<Answer> answers34 = Arrays.asList(
                new Answer((int) questionId34, "Giảm tốc độ và quan sát.", true),
                new Answer((int) questionId34, "Đi nhanh để vượt qua.", false),
                new Answer((int) questionId34, "Dừng lại để nhường đường.", false),
                new Answer((int) questionId34, "Đi chậm và chú ý tín hiệu giao thông.", false)
        );
        quizDao.insertAnswers(answers34);

// Question 15
        Question question35 = new Question("Khi lái xe qua cầu hẹp, người lái xe phải làm gì?", 15, "Đề 2");
        long questionId35 = quizDao.insertQuestion(question35);
        List<Answer> answers35 = Arrays.asList(
                new Answer((int) questionId35, "Đi nhanh để tránh ùn tắc.", false),
                new Answer((int) questionId35, "Giảm tốc độ và đi đúng phần đường của mình.", true),
                new Answer((int) questionId35, "Bấm còi liên tục để báo hiệu cho người khác.", false),
                new Answer((int) questionId35, "Đi vào giữa cầu để đảm bảo an toàn.", false)
        );
        quizDao.insertAnswers(answers35);

// Question 16
        Question question36 = new Question("Khi đèn tín hiệu giao thông màu xanh, bạn phải làm gì?", 16, "Đề 2");
        long questionId36 = quizDao.insertQuestion(question36);
        List<Answer> answers36 = Arrays.asList(
                new Answer((int) questionId36, "Dừng lại.", false),
                new Answer((int) questionId36, "Đi chậm lại.", false),
                new Answer((int) questionId36, "Tiếp tục đi.", true),
                new Answer((int) questionId36, "Nhìn tín hiệu của người đi bộ.", false)
        );
        quizDao.insertAnswers(answers36);

// Question 17
        Question question37 = new Question("Người điều khiển xe phải làm gì khi có tín hiệu của xe cứu thương?", 17, "Đề 2");
        long questionId37 = quizDao.insertQuestion(question37);
        List<Answer> answers37 = Arrays.asList(
                new Answer((int) questionId37, "Tiếp tục đi vì xe cứu thương phải tự tìm cách vượt qua.", false),
                new Answer((int) questionId37, "Giảm tốc độ nhưng không cần tránh đường.", false),
                new Answer((int) questionId37, "Nhanh chóng giảm tốc độ và tránh đường cho xe cứu thương.", true),
                new Answer((int) questionId37, "Đi sát vào lề đường và nhường đường khi an toàn.", false)
        );
        quizDao.insertAnswers(answers37);

// Question 18
        Question question38 = new Question("Biển báo nào có hiệu lực cảnh báo nguy hiểm?", 18, "Đề 2");
        long questionId38 = quizDao.insertQuestion(question38);
        List<Answer> answers38 = Arrays.asList(
                new Answer((int) questionId38, "Biển báo chỉ dẫn.", false),
                new Answer((int) questionId38, "Biển báo nguy hiểm.", true),
                new Answer((int) questionId38, "Biển báo cấm.", false),
                new Answer((int) questionId38, "Biển báo hiệu lệnh.", false)
        );
        quizDao.insertAnswers(answers38);

// Question 19
        Question question39 = new Question("Khi đèn tín hiệu giao thông màu vàng, bạn phải làm gì?", 19, "Đề 2");
        long questionId39 = quizDao.insertQuestion(question39);
        List<Answer> answers39 = Arrays.asList(
                new Answer((int) questionId39, "Dừng lại.", true),
                new Answer((int) questionId39, "Tiếp tục đi.", false),
                new Answer((int) questionId39, "Đi chậm lại.", false),
                new Answer((int) questionId39, "Nhìn tín hiệu của người đi bộ.", false)
        );
        quizDao.insertAnswers(answers39);

// Question 20
        Question question40 = new Question("Khi lái xe vào ban đêm, bạn phải sử dụng đèn nào để đảm bảo an toàn?", 20, "Đề 2");
        long questionId40 = quizDao.insertQuestion(question40);
        List<Answer> answers40 = Arrays.asList(
                new Answer((int) questionId40, "Đèn chiếu gần.", true),
                new Answer((int) questionId40, "Đèn chiếu xa.", false),
                new Answer((int) questionId40, "Đèn pha.", false),
                new Answer((int) questionId40, "Đèn xi nhan.", false)
        );
        quizDao.insertAnswers(answers40);

    }
}
