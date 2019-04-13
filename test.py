

import os, shutil


folder = '/Users/home/Library/Safari/'
# browser = raw_input("Enter : ")

# if browser == "safari":
# 	folder = '/Users/home/Library/Safari/'
# elif browser == "chrome":
# 	folder = 'Users/home/Library/Application Support'


for the_file in os.listdir(folder):
    file_path = os.path.join(folder, the_file)
    try:
        if os.path.isfile(file_path):
            os.unlink(file_path)
        elif os.path.isdir(file_path): shutil.rmtree(file_path)
    except Exception as e:
        print(e)



#/Google/Chrome/Default



