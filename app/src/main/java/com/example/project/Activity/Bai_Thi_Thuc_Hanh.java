package com.example.project.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project.R;

public class Bai_Thi_Thuc_Hanh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai_thi_thuc_hanh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Đặt nội dung cho TextView
        TextView textViewI = findViewById(R.id.textViewI);
        textViewI.setText(getLyThuyetTextI());

        TextView textViewII = findViewById(R.id.textViewII);
        textViewII.setText(getLyThuyetTextII());

        TextView textViewIII = findViewById(R.id.textViewIII);
        textViewIII.setText(getLyThuyetTextIII());



        // Đặt hình ảnh cho ImageView nếu cần từ mã Java
        ImageView imageViewI = findViewById(R.id.imageViewI);
        imageViewI.setImageResource(R.drawable.baithi); // Thay 'image_i' bằng tên file hình ảnh trong thư mục drawable

        ImageView imageViewII = findViewById(R.id.imageViewII);
        imageViewII.setImageResource(R.drawable.baithi2); // Thay 'image_ii' bằng tên file hình ảnh trong thư mục drawable

        ImageView imageViewIII = findViewById(R.id.imageViewIII);
        imageViewIII.setImageResource(R.drawable.baithi3); // Thay 'image_iii' bằng tên file hình ảnh trong thư mục drawable
    }

    private String getLyThuyetTextI() {
        return "1. Bài thi Xuất phát\n" +
                "Thao tác chuẩn bị: Hãy kiểm tra mọi thứ trước khi bắt đầu xuất phát, ngồi đúng tư thế, đặt chân sẵn sàng để thực hiện thao tác như lái, côn, ga, phanh,… được dễ dàng và thoải mái nhất. Chỉnh gương hai bên và gương chiếu hậu để quan sát đầy đủ nhất phần đường hai bên và không gian phía sau xe. Cuối cùng thắt dây an toàn, đề máy nổ và chuẩn bị sẵn sàng cho bài thi.\n" +
                "\n" +
                "Các bước thực hiện bài thi:\n" +
                "\n" +
                "- Bật đèn xi nhan trái rồi vào số 1, nhả côn từ từ cho xe chạy\n" +
                "\n" +
                "- Khi đi qua vạch xuất phát khoảng 5m thì tắt xi nhan (đèn xanh trên xe tắt)\n" +
                "\n" +
                "- Khi xe đã di chuyển thì bạn nhả côn cho xe chạy, không cần đạp ga. Vậy là hoàn thành và bạn sẽ đi đến bài thi số 2.\n" +
                "\n" +
                "Yêu cầu của phần thi Xuất phát:\n" +
                "\n" +
                "Phải thắt dây an toàn trước khi xuất phát\n" +
                "Nhẹ nhàng khởi động, trong thời gian 20 giây không bị rung giât\n" +
                "Cần bật đèn xi nhan trái trước khi xuất phát\n" +
                "Sau khi đi khỏi vạch xuất phát khoảng 5m thì tắt đèn xi nhan trái\n" +
                "Tốc độ động cơ không được quá 4.000 vòng/phút\n" +
                "Chạy xe với tốc độ không quá 24 km/h (với hạng B, hạng D) và 20km (với hạng C, hạng E)\n" +
                "Lái xe đúng với quy định giao thông đường bộ\n"
                ;
    }

    private String getLyThuyetTextII() {
        return "2. Bài thi Dừng xe và nhường đường cho người đi bộ\n" +
                "Thao tác chuẩn bị: Sau khi hoàn thành bài thi Xuất phát, thí sinh sẽ chuyển đến bài thi thứ hai với nội dung \"Dừng xe và nhường đường cho người đi bộ\" sao cho: Dừng xe đúng chỗ trước trước vạch trắng và vạch sọc ngựa vằn (là đường dành cho người đi bộ). Khoảng cách từ thanh cản phía trước đến vạch dừng không quá 500mm.\n" +
                "\n" +
                "Bài thi Dừng xe và nhường đường cho người đi bộ.\n" +
                "\n" +
                "Các yêu cầu bài thi:\n" +
                "\n" +
                "Dừng xe ở khách cách dưới 500mm từ thanh cản phía trước ô tô đến vạch dừng\n" +
                "Giữ động cơ chạy liên tục, không để chết máy\n" +
                "Lái xe đúng theo quy định giao thông đường bộ với tốc độ di chuyển không được quá 24 km/h đối với hạng B,D và không quá 20km/h đối với hạng C,E\n" +
                "Những lỗi bị trừ điểm:\n" +
                "\n" +
                "Trừ 5 điểm: Khi không dừng ở vạch dừng đúng theo quy định\n" +
                "Trừ 5 điểm: Khi dừng xe ở khoảng cách từ thanh cản phía trước ô tô đến vạch dừng lớn hơn 500mm\n" +
                "Trừ 5 điểm: Khi dừng xe quá vạch dừng quy định\n" +
                "Trừ 5 điểm: Khi xe không hoạt động liên tục, để xe bị chết máy, mỗi lần bị trừ 5 điểm\n" +
                "Trừ 5 điểm: Khi để tốc độ động cơ vượt quá 4.000 vòng/phút, mỗi lần bị trừ 5 điểm\n" +
                "Trừ 1 điểm: Khi lái xe quá tốc độ cho phép theo quy định luật giao thông đường bộ, cứ 3 giây sẽ bị trừ 1 điểm\n" +
                "Trừ 1 điểm: Khi tổng số thời gian thực hiện bài thi sát hạch quá quy định, cứ 3 giây sẽ bị trừ đi 1 điểm\n" +
                "Người thi sẽ bị truất quyền sát hạch nếu phạm các lỗi sau đây: Quá 30 giây mà xe của bạn vẫn chưa xuất phát; Lái xe không đúng, lên vỉa hè; Gây tai nạn khi thực hành; Dưới 80 điểm sát hạch lái xe ô tô.\n"
                ;
    }

    private String getLyThuyetTextIII() {
        return "Bài thi thực hành “Dừng và khởi hành xe lên dốc” được coi là bài thi khó nhất cho các thí sinh tham gia sát hạch. Nếu vượt qua bài thi này thì bạn gần như chắc chắn vượt qua bài thi thực hành. Nhưng trong thực tế rất nhiều thí sinh đã bị loại ở bài thi này, đặc biệt là người tham gia lần đầu khi chưa có kinh nghiệm lái xe.\n" +
                "\n" +
                "Yêu cầu bài thi\n" +
                "\n" +
                "Dừng xe cách vạch dừng quy định không quá 500 mm;\n" +
                "Khởi hành xe mượt mà, không bị tụt dốc quá 500 mm;\n" +
                "Xe qua vị trí dừng trong khoảng thời gian 30 giây;\n" +
                "Giữ động cơ hoạt động liên tục\n" +
                "Giữ tốc độ động cơ không quá 4.000 vòng/phút;\n" +
                "Lái xe theo quy tắc giao thông đường bộ;\n" +
                "Tốc độ xe chạy không quá: 24 km/h đối với hạng B, D; 20 km/h đối với hạng C, E\n" +
                "Kinh nghiệm vượt qua bài thi Dừng và khởi hành xe ngang dốc:\n" +
                "\n" +
                "B1: Treo xe trên dốc\n" +
                "\n" +
                "-    Mục tiêu: treo xe trên dốc không bị tụt.\n" +
                "\n" +
                "-    Phương pháp: bạn phải giữ phanh, mở côn tới khi kim xuống khoảng 500 vòng tua.\n" +
                "\n" +
                "B2: Khởi hành xe trên dốc\n" +
                "\n" +
                "Cách 1: Theo kinh nghiệm dạy lái xe của trường\n" +
                "\n" +
                "Sau khi xe đã dừng trên dốc, bạn kéo phanh tay với mục đích là thay phanh chân giữ xe tại điểm dừng. Khi đó, bạn có thể bỏ chân phanh ra và đặt vào chân ga mớm lên. Đồng thời chân trái nhả côn từ từ, đến khi thấy tay lái hoặc cần số rung lên (báo hiệu các lá côn đã bắt vào nhau) thì nhả nhẹ phanh tay, nghe ngóng nếu thấy xe không trượt thì thả nốt phanh tay, xe sẽ tự bò lên.\n" +
                "\n" +
                "Bài thi Đề pha ngang dốc.\n" +
                "\n" +
                "Cách 2: Kinh nghiệm lái xe thực tế\n" +
                "\n" +
                "Khi lái xe căn đúng điểm vạch và phải dừng trước vạch, chú ý không để xe cán vạch như vậy bạn sẽ không bị trừ điểm. Sau khi dừng đạp hết côn và phanh ra, không để chừa chân côn hay chân ga. Làm như vậy hoàn toàn sai và bạn có thể bị loại ngay, bởi như vậy là sai quy định. Nguyên tắc dừng ở dốc chúng ta cần đạp hết côn và đạp hết phanh.\n" +
                "\n" +
                "Chờ khoảng vài giây thì trong máy kêu “tinh” chúng ta chuẩn bị cho bài thi tiếp theo. Sau đó bạn nhả côn ra từ từ khi đó xe sẽ “rung lên”, khi này vòng tua máy lên 1.200 vòng/phút thì bạn mở hết chân phanh ra, không mớm phanh và sau đó mở côn ra hết thì xe bắt đầu đi lên từ từ. Giải thích lý do vì khi mở hết côn ra thì động cơ máy bắt đầu “gồng lên” thì xe sẽ không bị lùi, nếu xe đi lùi thì xe sẽ bị chết máy.\n" +
                "\n" +
                "Còn một trường hợp nữa, lúc xe \"gồng lên\" thì bạn mở côn ra từ từ, chân phải nhả chân phanh ra nhấn qua chân ga thì chiếc xe sẽ phóng lên. Cách làm này chỉ cho những tài xế đã khá chắc chắn khi lái xe.\n" +
                "\n" +
                "Những lỗi bị trừ điểm:\n" +
                "\n" +
                "Không dừng xe ở vạch quy định, bị truất quyền thi.\n" +
                "Dừng xe chưa đến vạch dừng quy định bị trừ 5 điểm.\n" +
                "Dừng xe quá vạch dừng quy định, bị truất quyền thi.\n" +
                "Quá thời gian 30 giây kể từ khi dừng xe không khởi hành qua vị trí dừng, bị truất quyền thi.\n" +
                "Xe bị tụt dốc quá 50cm kể từ khi dừng xe, bị truất quyền thi.\n" +
                "Xử lý tình huống không hợp lý gây tai nạn, bị truất quyền thi.\n" +
                "Xe bị chết máy, mỗi lần bị trừ 5 điểm.\n" +
                "Để tốc độ động cơ quá 4.000 vòng/phút, mỗi lần bị trừ 5 điểm.\n" +
                "Lái xe quá tốc độ quy định, cứ 3 giây bị trừ 1 điểm.\n" +
                "Chậm thời gian quy định, cứ chậm 3s bị trừ 1 điểm\n"

                ;
    }
}