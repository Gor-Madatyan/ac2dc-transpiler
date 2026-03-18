#include <stdlib.h>
#include <string.h>

struct {
  int size;
  char **tokens;
} typedef output;

static int word_count(char *str) {
  int words_count = 0;
  for (char *i = str; *i != '\0'; i++) {
    if (*i == ' ' || *i == '\n' || *i == '\r' || *i == '\t')
      continue;

    if ((i > str && (*(i - 1) == ' ' || *(i - 1) == '\t')) || i == str)
      words_count++;
  }
  return words_count;
}

output lex(char *str) {
  int words_count = word_count(str);
  int _words_count = words_count;
  char **words = malloc(_words_count * sizeof(char *));

  for (char *i = str; *i != '\0' && _words_count > 0; i++) {
    if (*i == ' ' || *i == '\n' || *i == '\t' || *i == '\r')
      continue;

    char *st = i;
    for (; *i != ' ' && *i != '\n' && *i != '\r' && *i != '\t' && *i != '\0';
         i++)
      ;

    int size = i - st;
    int idx = words_count - _words_count;
    _words_count--;
    words[idx] = calloc(size + 1, sizeof(char));

    strncpy(words[idx], st, size);
  }

  return (output){words_count, words};
}

void freeOutput(output out) {
  for (int i = 0; i < out.size; i++) {
    free(out.tokens[i]);
  }
  free(out.tokens);
}
