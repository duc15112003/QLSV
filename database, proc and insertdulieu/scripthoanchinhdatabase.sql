USE [master]
GO
/****** Object:  Database [QLSV]    Script Date: 6/13/2023 3:11:33 PM ******/
CREATE DATABASE [QLSV]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLSV', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QLSV.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLSV_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QLSV_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QLSV] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLSV].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLSV] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLSV] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLSV] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLSV] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLSV] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLSV] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLSV] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLSV] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLSV] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLSV] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLSV] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLSV] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLSV] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLSV] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLSV] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLSV] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLSV] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLSV] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLSV] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLSV] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLSV] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLSV] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLSV] SET RECOVERY FULL 
GO
ALTER DATABASE [QLSV] SET  MULTI_USER 
GO
ALTER DATABASE [QLSV] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLSV] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLSV] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLSV] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLSV] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLSV] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLSV', N'ON'
GO
ALTER DATABASE [QLSV] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLSV] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLSV]
GO
/****** Object:  User [duc]    Script Date: 6/13/2023 3:11:33 PM ******/
CREATE USER [duc] FOR LOGIN [duc] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[ADMIN_controll]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ADMIN_controll](
	[maadmin] [nvarchar](10) NOT NULL,
	[tenadmin] [nvarchar](50) NULL,
	[gioitinh] [nvarchar](50) NULL,
	[diachi] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_ADMIN] PRIMARY KEY CLUSTERED 
(
	[maadmin] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BangUser]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangUser](
	[id] [nvarchar](10) NOT NULL,
	[matkhau] [nvarchar](50) NULL,
	[loaitk] [nvarchar](50) NULL,
 CONSTRAINT [PK_BangUser] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cahoc]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cahoc](
	[cahoc] [nvarchar](50) NOT NULL,
	[tencahoc] [nvarchar](50) NULL,
 CONSTRAINT [PK_cahoc] PRIMARY KEY CLUSTERED 
(
	[cahoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DIEMDANH]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DIEMDANH](
	[masv] [nvarchar](10) NULL,
	[ComathoacVangmat] [bit] NULL,
	[malichhoc] [nvarchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DIEMHOCPHAN]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DIEMHOCPHAN](
	[masv] [nvarchar](10) NOT NULL,
	[mahocphan] [nvarchar](10) NOT NULL,
	[diemhocphan] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HeDT]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HeDT](
	[Mahe] [nvarchar](50) NOT NULL,
	[Tenhe] [nvarchar](50) NULL,
 CONSTRAINT [PK_HeDT] PRIMARY KEY CLUSTERED 
(
	[Mahe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOCPHAN]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOCPHAN](
	[mahocphan] [nvarchar](10) NOT NULL,
	[tenhocphan] [nvarchar](100) NULL,
	[sodvht] [int] NULL,
	[manganh] [nvarchar](12) NULL,
	[hocki] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[mahocphan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHOAHOC]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHOAHOC](
	[makhoahoc] [nvarchar](10) NOT NULL,
	[tenkhoahoc] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[makhoahoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LICHHOC]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LICHHOC](
	[masv] [nvarchar](10) NULL,
	[ngayhoc] [date] NULL,
	[cahoc] [nvarchar](50) NULL,
	[thoigian] [nvarchar](50) NULL,
	[malichhoc] [nvarchar](10) NOT NULL,
	[PhongHoc] [nvarchar](50) NULL,
	[mamonhoc] [nvarchar](10) NULL,
 CONSTRAINT [PK_LICHHOC] PRIMARY KEY CLUSTERED 
(
	[malichhoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOPHOC]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOPHOC](
	[malophoc] [nvarchar](10) NOT NULL,
	[tenlop] [nvarchar](50) NULL,
	[manganh] [nvarchar](12) NULL,
	[khoahoc] [nvarchar](50) NULL,
	[hedaotao] [nvarchar](50) NULL,
	[namnhaphoc] [nvarchar](4) NULL,
 CONSTRAINT [PK__LOPHOC__652FFDDD280140B8] PRIMARY KEY CLUSTERED 
(
	[malophoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NGANHHOC]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NGANHHOC](
	[manganhhoc] [nvarchar](12) NOT NULL,
	[tennganhhoc] [nvarchar](100) NULL,
	[makhoa] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[manganhhoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SINHVIEN]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SINHVIEN](
	[masinhvien] [nvarchar](10) NOT NULL,
	[hotensinhvien] [nvarchar](100) NULL,
	[malop] [nvarchar](10) NULL,
	[gioitinh] [nvarchar](20) NULL,
	[ngaysinh] [date] NULL,
	[diachi] [nvarchar](max) NULL,
	[email] [nvarchar](50) NULL,
	[anh] [nvarchar](max) NULL,
 CONSTRAINT [PK__SINHVIEN__0C8D7038A190B4EC] PRIMARY KEY CLUSTERED 
(
	[masinhvien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[ADMIN_controll]  WITH CHECK ADD  CONSTRAINT [FK_ADMIN_controll_BangUser] FOREIGN KEY([maadmin])
REFERENCES [dbo].[BangUser] ([id])
GO
ALTER TABLE [dbo].[ADMIN_controll] CHECK CONSTRAINT [FK_ADMIN_controll_BangUser]
GO
ALTER TABLE [dbo].[DIEMDANH]  WITH CHECK ADD  CONSTRAINT [FK_DIEMDANH_LICHHOC] FOREIGN KEY([malichhoc])
REFERENCES [dbo].[LICHHOC] ([malichhoc])
GO
ALTER TABLE [dbo].[DIEMDANH] CHECK CONSTRAINT [FK_DIEMDANH_LICHHOC]
GO
ALTER TABLE [dbo].[DIEMDANH]  WITH CHECK ADD  CONSTRAINT [FK_DIEMDANH_SINHVIEN] FOREIGN KEY([masv])
REFERENCES [dbo].[SINHVIEN] ([masinhvien])
GO
ALTER TABLE [dbo].[DIEMDANH] CHECK CONSTRAINT [FK_DIEMDANH_SINHVIEN]
GO
ALTER TABLE [dbo].[DIEMHOCPHAN]  WITH CHECK ADD  CONSTRAINT [FK_DIEMHOCPHAN_HOCPHAN] FOREIGN KEY([mahocphan])
REFERENCES [dbo].[HOCPHAN] ([mahocphan])
GO
ALTER TABLE [dbo].[DIEMHOCPHAN] CHECK CONSTRAINT [FK_DIEMHOCPHAN_HOCPHAN]
GO
ALTER TABLE [dbo].[DIEMHOCPHAN]  WITH CHECK ADD  CONSTRAINT [FK_DIEMHOCPHAN_SINHVIEN] FOREIGN KEY([masv])
REFERENCES [dbo].[SINHVIEN] ([masinhvien])
GO
ALTER TABLE [dbo].[DIEMHOCPHAN] CHECK CONSTRAINT [FK_DIEMHOCPHAN_SINHVIEN]
GO
ALTER TABLE [dbo].[HOCPHAN]  WITH CHECK ADD  CONSTRAINT [FK_HOCPHAN_NGANHHOC] FOREIGN KEY([manganh])
REFERENCES [dbo].[NGANHHOC] ([manganhhoc])
GO
ALTER TABLE [dbo].[HOCPHAN] CHECK CONSTRAINT [FK_HOCPHAN_NGANHHOC]
GO
ALTER TABLE [dbo].[LICHHOC]  WITH CHECK ADD  CONSTRAINT [FK_LICHHOC_cahoc] FOREIGN KEY([cahoc])
REFERENCES [dbo].[cahoc] ([cahoc])
GO
ALTER TABLE [dbo].[LICHHOC] CHECK CONSTRAINT [FK_LICHHOC_cahoc]
GO
ALTER TABLE [dbo].[LICHHOC]  WITH CHECK ADD  CONSTRAINT [FK_LICHHOC_HOCPHAN] FOREIGN KEY([mamonhoc])
REFERENCES [dbo].[HOCPHAN] ([mahocphan])
GO
ALTER TABLE [dbo].[LICHHOC] CHECK CONSTRAINT [FK_LICHHOC_HOCPHAN]
GO
ALTER TABLE [dbo].[LOPHOC]  WITH CHECK ADD  CONSTRAINT [FK_LOPHOC_HeDT] FOREIGN KEY([hedaotao])
REFERENCES [dbo].[HeDT] ([Mahe])
GO
ALTER TABLE [dbo].[LOPHOC] CHECK CONSTRAINT [FK_LOPHOC_HeDT]
GO
ALTER TABLE [dbo].[LOPHOC]  WITH CHECK ADD  CONSTRAINT [FK_LOPHOC_NGANHHOC] FOREIGN KEY([manganh])
REFERENCES [dbo].[NGANHHOC] ([manganhhoc])
GO
ALTER TABLE [dbo].[LOPHOC] CHECK CONSTRAINT [FK_LOPHOC_NGANHHOC]
GO
ALTER TABLE [dbo].[NGANHHOC]  WITH CHECK ADD  CONSTRAINT [FK_NGANHHOC_KHOAHOC] FOREIGN KEY([makhoa])
REFERENCES [dbo].[KHOAHOC] ([makhoahoc])
GO
ALTER TABLE [dbo].[NGANHHOC] CHECK CONSTRAINT [FK_NGANHHOC_KHOAHOC]
GO
ALTER TABLE [dbo].[SINHVIEN]  WITH CHECK ADD  CONSTRAINT [FK_SINHVIEN_BangUser] FOREIGN KEY([masinhvien])
REFERENCES [dbo].[BangUser] ([id])
GO
ALTER TABLE [dbo].[SINHVIEN] CHECK CONSTRAINT [FK_SINHVIEN_BangUser]
GO
ALTER TABLE [dbo].[SINHVIEN]  WITH CHECK ADD  CONSTRAINT [FK_SINHVIEN_LOPHOC] FOREIGN KEY([malop])
REFERENCES [dbo].[LOPHOC] ([malophoc])
GO
ALTER TABLE [dbo].[SINHVIEN] CHECK CONSTRAINT [FK_SINHVIEN_LOPHOC]
GO
/****** Object:  StoredProcedure [dbo].[sp_checkemail]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 create proc [dbo].[sp_checkemail](@email nvarchar(Max))
  as 
  begin
  select email from SINHVIEN where email = @email;
  end
GO
/****** Object:  StoredProcedure [dbo].[sp_diemdanh]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_diemdanh](@masinhvien nvarchar(50))
as
begin
select dd.malichhoc,lh.mamonhoc,lh.cahoc,dd.ComathoacVangmat 
from DIEMDANH dd inner join LICHHOC lh on dd.malichhoc = lh.malichhoc where dd.masv = @masinhvien
end
GO
/****** Object:  StoredProcedure [dbo].[sp_diemdanhtheomamonhoc]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_diemdanhtheomamonhoc](@masinhvien nvarchar(50),@mamonhoc nvarchar(50))
as
begin
select dd.malichhoc,lh.mamonhoc,lh.cahoc,dd.ComathoacVangmat 
from DIEMDANH dd inner join LICHHOC lh on dd.malichhoc = lh.malichhoc where dd.masv = @masinhvien and lh.mamonhoc = @mamonhoc
end
GO
/****** Object:  StoredProcedure [dbo].[sp_filldataddct]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_filldataddct](@malop nvarchar(50))
as
begin
select sv.masinhvien,lh.malichhoc,sv.anh,lh.cahoc,sv.malop
from SINHVIEN sv inner join LICHHOC lh on sv.masinhvien = lh.masv where sv.malop = @malop
end
GO
/****** Object:  StoredProcedure [dbo].[sp_Findnamefromma]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_Findnamefromma](@tenmon nvarchar(50))
as
begin
select mahocphan from HOCPHAN where tenhocphan = @tenmon;
end
GO
/****** Object:  StoredProcedure [dbo].[sp_lichhoc]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_lichhoc](@masv nvarchar(50))
as
begin

select ngayhoc,cahoc,thoigian,malichhoc,PhongHoc,mamonhoc from LICHHOC where masv = @masv
end
GO
/****** Object:  StoredProcedure [dbo].[sp_lichhoctheongay]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_lichhoctheongay](@masv nvarchar(50), @ngay nvarchar(50))
as
begin
select ngayhoc,cahoc,thoigian,malichhoc,PhongHoc,mamonhoc from LICHHOC where masv = @masv and ngayhoc = @ngay
end
GO
/****** Object:  StoredProcedure [dbo].[sp_Loaitk]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_Loaitk] (@id nvarchar(50))

as
begin
select loaitk from BangUser where id = @id
end
GO
/****** Object:  StoredProcedure [dbo].[sp_Login]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_Login] (@id nvarchar(50),@email nvarchar(50),@pass nvarchar(50))

as
begin 

select * from BangUser where id = @id and email = @email and matkhau = @pass

end;
GO
/****** Object:  StoredProcedure [dbo].[sp_Login_1]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_Login_1] (@id nvarchar(50))
as
begin 
select * from BangUser where id = @id
end;
GO
/****** Object:  StoredProcedure [dbo].[sp_Tenadmin]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_Tenadmin](@id nvarchar(50))
as
begin
select tenadmin from ADMIN_controll where maadmin = @id
end
GO
/****** Object:  StoredProcedure [dbo].[sp_tenchutk]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_tenchutk] (@id nvarchar(50))

as
begin
select hotensinhvien from SINHVIEN where masinhvien = @id
end
GO
/****** Object:  StoredProcedure [dbo].[sp_Timkiemsv]    Script Date: 6/13/2023 3:11:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  create proc [dbo].[sp_Timkiemsv](@email nvarchar(Max))
  as 
  begin
  select masinhvien from SINHVIEN where email = @email;
  end
GO
USE [master]
GO
ALTER DATABASE [QLSV] SET  READ_WRITE 
GO
