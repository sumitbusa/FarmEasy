<?php
	class connectivty{
		private $conn;
		private $hostname;
		private $username;
		private $password;
		private $database;
		function __construct($hname, $uname, $passwd, $db){
			$this->hostname = $hname;
			$this->username = $uname;
			$this->password = $passwd;
			$this->database = $db;
			$this->connect();
		}
		function connect(){
					$this->conn = new mysqli($this->hostname,$this->username,$this->password,$this->database);
						if ($this->conn->connect_error) {
    						die("Connection failed: " . $this->conn->connect_error);
						}
		}
		function executeQuery($sql){
			$result = $this->conn->query($sql);
			return  $result;
		}
		function noRow($result){
			return $result->num_rows;
		}
		function loginData($user,$paswd){
			if ($user != null && $paswd !=null) {
				$sql = "select `id` from admin where `email`='".$user."' AND `password`='".md5($paswd)."'";
				$result = $this->executeQuery($sql);
				if($this->noRow($result) > 0){
					return true;
				}
				else{
					return false;
				}	
			}
		}
		function __destruct(){
			if($this->conn){
				$this->conn->close;
			}
		}
	}
	$obj =new connectivty("localhost","u101328015_busa","Ni1c8GE1IZ","u101328015_admin");
	
	$result = $obj->executeQuery("select * from Machinery");
	$dealerarray = array();
	if ($result->num_rows > 0) {
    		// output data of each row
    		while($row = $result->fetch_assoc()) {
    			$dealerarray[] = $row;
        		//echo "id: " . $row["id"]. " - Name: " . $row["company_name"]. " " . $row["phone_no"]. " ".$row["type"]."".$row["Address"]."<br>";
    		}
		} else {
    			echo "0 results";
		}

			echo json_encode(array("server_response"=>($dealerarray)));
			// usernam or  password is wrong
		//	array_push($response, array("Login" => "false"));
	//echo json_encode(array("login_credential" =>  $response));
?>