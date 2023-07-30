* Database : sử dụng mySQL
      - Kết nối ở file JDBCUntil.java
* Phần đăng nhập :
    - Chọn khách hàng có 2 trường hợp xảy ra :
        + Đã có thông tin của khách hàng đó trong db thì vào thẳng store
        + Chưa có thông tin khách hàng trong db thì chuyển sang phần đăng kí, xong sẽ vào thẳng store
        + Phần đăng kí sẽ có mục nhập mã nhân viên tiếp đón mình nhân viên này sẽ xử lí tất cả các dịch vụ của khách hàng mới này 
    - Với lựa chọn là nhân viên thì tương tự trên
    - Chọn thoát là thoát hẳn chương trình 
    - Điều kiện khách hàng/nhân viên phải nhớ mã khách hàng/nhân viên của mình tương tự như username và password
    - Đã xử lí trường hợp người dùng nhập sai kiểu dữ liệu yêu cầu, nhập số âm nếu nhập sai sẽ bắt nhập lại
      
* Phần store :
    - Có 2 menu chính là khách hàng và nhân viên (xem trong file model/Menu.java)
    - Nhân viên :
        + CN1 : Thêm sách vào kho : Nhập mã sách nếu sách này hiện đang có trong db thì sẽ nhập số lượng để thêm vào nếu mã sách nhập vào chưa có thông tin trong db thì sẽ phải nhập đầy đủ thông tin của sách đó (tên sách , tác giả, thể loại mô tả giá nhập giá bán, ...)
        + 
