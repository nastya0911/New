import xml.etree.ElementTree as ET

def process_books(xml_file):
    tree = ET.parse(xml_file)
    root = tree.getroot()
    
    # Вывод списка книг
    print("Список книг:")
    total_price = 0
    book_count = 0
    for book in root.findall('book'):
        title = book.find('title').text
        author = book.find('author').text
        year = book.find('year').text
        genre = book.find('genre').text
        price = float(book.find('price').text)
        print(f"Название: {title}, Автор: {author}, Год: {year}, Жанр: {genre}, Цена: {price}")
        total_price += price
        book_count += 1
    
    # Средняя цена книг
    average_price = total_price / book_count if book_count > 0 else 0
    print(f"Средняя цена книг: {average_price:.2f}")
    
    # Фильтрация книг по жанру
    filter_genre = "Роман"
    print(f"\nКниги жанра '{filter_genre}':")
    for book in root.findall('book'):
        genre = book.find('genre').text
        if genre == filter_genre:
            title = book.find('title').text
            print(f"Название: {title}")

# Указание файла XML
process_books('library.xml')
