<html>
    <?php
        require_once("notify.php");

        $to = "emHSTF25QQuQv2BbN2z_AX:APA91bFGKFVP8hF1pUYpOOcfQaNgcNDhMR5-Pel7fTW8IyqDY2L3TivVhgxlmqiQA57GwFJPObroKUtABghmGPliOQHiWuU4iVi_XPXhZC_h_qHvc4e2iQ8Ai2C6BD1gqsBt9271QCVX";
        $data = array(
            'title' => 'Notification',
            'body' => "You've got a new message!"
        );

        $localhost = "localhost";
        $db_username = "root";
        $db_password = "";
        $db_name = "chatapp";

        $conn = mysqli_connect($localhost, $db_username, $db_password) or die(mysqli_error()); //Database connection
        $db_select = mysqli_select_db($conn, $db_name) or die(mysqli_error()); //Database selection
    ?>

    <head>
        <title>Chatapp</title>
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
        <link href='css/bootstrap.min.css' rel='stylesheet'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <style>
        body {
            font-family: 'Roboto'
            }
    </style>

    <body>
        <div class="container">
            <div style="overflow:auto;">
                <table style="width: 100%" class="table table-borderless table-sm">
                    <thead>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </thead>
                    
                    <tbody>
                        <?php
                            $sql = "SELECT * FROM chat ORDER BY waktu";
                            $res = mysqli_query($conn, $sql);

                            while($row=mysqli_fetch_assoc($res)){
                                $nama = $row['nama'];
                                $chat = $row['chat'];
                                $waktu = $row['waktu'];
                        ?>

                        <tr>
                                <?php 
                                if (strtolower($row['nama']) == "lani") { ?>
                                    <td style="color: orange"><?php echo $nama; ?></td>
                                    <td style="text-align: right; color: orange">:</td>
                                    <td style="color: orange"><?php echo $chat; ?></td>
                                    <td style="text-align: right; color: grey; font-size: 10px"><?php echo $waktu; ?></td>
                                <?php
                                } 
                                elseif (strtolower($row['nama']) == "siti") { ?>
                                    <td style="color: green"><?php echo $nama; ?></td>
                                    <td style="text-align: right; color: green">:</td>
                                    <td style="color: green"><?php echo $chat; ?></td>
                                    <td style="text-align: right; color: grey; font-size: 10px"><?php echo $waktu; ?></td>
                                <?php
                                } 
                                ?>
                            <?php
                                }
                            ?>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="container">
            <div style="height:320px;">
                <form action="#" method="GET" name="chat">
                        <input type="hidden" class="form-control" name="nama" placeholder="Nama" aria-label="Username" aria-describedby="basic-addon1">

                        <input name="chat" type="hidden" class="form-control" placeholder="Tulis pesan disini" >

                    <input class="btn btn-primary" type="hidden" value="kirim" name="submit" style="margin-top: 8px; float: right;">
                </form>
            </div>
        </div>
    </body>
  
</html>

<?php 
    if(isset($_GET["submit"])){
        $nama = $_GET["nama"];
        $chat = $_GET["chat"];
        $waktu    = date ("Y-m-d, H:i a");

        if (empty($_GET['nama']) || empty($_GET['chat'])) { ?>
            <script language="JavaScript">
                alert('Data yang Anda masukan tidak lengkap!');
                document.location='index.php';
            </script>
        <?php
        }

        elseif (strtolower($_GET['nama']) == "lani") {
            //Step 2. SQL Query to save the data into database
            $sql = "INSERT INTO chat (nama, chat, waktu) VALUES ('$nama', '$chat', '$waktu')
            ";
            $res = mysqli_query($conn, $sql) or die(mysqli_error($conn));

            if ($res) {
                notify($to, $data);
                ?>
                <script language="JavaScript">
                    document.location='index.php';
                </script>
                <?php
            } else{
                echo'Dbase E';
            }
        }

        elseif (strtolower($_GET['nama']) == "siti") {
            //Step 2. SQL Query to save the data into database
            $sql = "INSERT INTO chat (nama, chat, waktu) VALUES ('$nama', '$chat', '$waktu')
            ";
            $res = mysqli_query($conn, $sql) or die(mysqli_error($conn));
        
            if ($res) {
                notify($to, $data);
                ?>
                <script language="JavaScript">
                    document.location='index.php';
                </script>
                <?php
            } else{
                echo'Dbase E';
            }
        }

        else { ?>
            <script language="JavaScript">
                alert('User tidak valid');
                document.location='index.php';
            </script>
        <?php
        }

    }
?>