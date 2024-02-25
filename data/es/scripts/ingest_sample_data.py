import pandas as pd
import datetime
import elasticsearch
from elasticsearch import helpers

df = pd.read_csv(
    "/Users/hsushenghin/Project/notebook/leetcode backend sample data/Leetcode Questions Summary b95129b3f73b4e44a57394fb25460b16_all.csv")
print(df.head())
print(df.columns)

print("preprocess")
df.columns = ['title', 'date', 'jira', 'tags', 'topic', 'isImportant', 'link', 'similar', "noteLink", "unique",
              "isPass"]
columns = ['title', 'date', 'tags', 'topic', 'isImportant', 'link', "noteLink", "isPass"]
df = df[columns]
df = df.dropna(subset=['title'])


def convert_date(x):
    if x:
        return datetime.datetime.strptime(x, '%B %d, %Y').strftime('%Y-%m-%d')
    return x


df['date'] = df['date'].fillna('').apply(convert_date)
for col in ['tags', 'noteLink', 'link', 'topic']:
    df[col].fillna('', inplace=True)
df['tags'] = df['tags'].apply(lambda x: x.split(','))


def convert_to_bool(x):
    if x == 'Yes':
        return True
    return False


for col in ['isImportant', 'isPass']:
    df[col] = df[col].apply(convert_to_bool)

es = elasticsearch.Elasticsearch()
es.ping()

print(f"Elasticsearch Connection: {es.ping()}")


docs = [
    {
        "_index": "question",
        "_source": i
    }
    for i in df.to_dict('records')]
res = helpers.bulk(es, docs)
print(res)
